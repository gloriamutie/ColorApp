package com.gloria.GameKids.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gloria.GameKids.R;
import com.gloria.GameKids.databinding.ActivityMultiFactorBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;

import java.util.List;

public class MultiFactorActivity extends BaseActivity implements View.OnClickListener {

    public static final int RESULT_NEEDS_MFA_SIGN_IN = 42;
    private static final String TAG = "MultiFactor";
    private static final int RC_MULTI_FACTOR = 9005;

    private ActivityMultiFactorBinding mBinding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMultiFactorBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setProgressBar(mBinding.progressBar);

        // Buttons
        mBinding.emailSignInButton.setOnClickListener(this);
        mBinding.signOutButton.setOnClickListener(this);
        mBinding.verifyEmailButton.setOnClickListener(this);
        mBinding.enrollMfa.setOnClickListener(this);
        mBinding.unenrollMfa.setOnClickListener(this);
        mBinding.reloadButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        showDisclaimer();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_MULTI_FACTOR) {
            if (resultCode == RESULT_NEEDS_MFA_SIGN_IN) {
                Intent intent = new Intent(this, MultiFactorSignInActivity.class);
                intent.putExtras(data.getExtras());
                startActivityForResult(intent, RC_MULTI_FACTOR);
            }
        }
    }

    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }

    private void sendEmailVerification() {
        // Disable button
        mBinding.verifyEmailButton.setEnabled(false);

        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        // Re-enable button
                        mBinding.verifyEmailButton.setEnabled(true);

                        if (task.isSuccessful()) {
                            Toast.makeText(MultiFactorActivity.this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(MultiFactorActivity.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [END_EXCLUDE]
                    }
                });
        // [END send_email_verification]
    }

    private void reload() {
        mAuth.getCurrentUser().reload().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    updateUI(mAuth.getCurrentUser());
                    Toast.makeText(MultiFactorActivity.this,
                            "Reload successful!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "reload", task.getException());
                    Toast.makeText(MultiFactorActivity.this,
                            "Failed to reload user.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updateUI(FirebaseUser user) {
        hideProgressBar();
        if (user != null) {
            mBinding.status.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail(), user.isEmailVerified()));
            mBinding.detail.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            List<MultiFactorInfo> secondFactors = user.getMultiFactor().getEnrolledFactors();

            if (secondFactors.isEmpty()) {
                mBinding.unenrollMfa.setVisibility(View.GONE);
            } else {
                mBinding.unenrollMfa.setVisibility(View.VISIBLE);

                StringBuilder sb = new StringBuilder("Second Factors: ");
                String delimiter = ", ";
                for (MultiFactorInfo x : secondFactors) {
                    sb.append(((PhoneMultiFactorInfo) x).getPhoneNumber() + delimiter);
                }
                sb.setLength(sb.length() - delimiter.length());
                mBinding.mfaInfo.setText(sb.toString());
            }

            mBinding.emailPasswordButtons.setVisibility(View.GONE);
            mBinding.signedInButtons.setVisibility(View.VISIBLE);

            int reloadVisibility = secondFactors.isEmpty() ? View.VISIBLE : View.GONE;
            mBinding.reloadButton.setVisibility(reloadVisibility);

            if (user.isEmailVerified()) {
                mBinding.verifyEmailButton.setVisibility(View.GONE);
                mBinding.enrollMfa.setVisibility(View.VISIBLE);
            } else {
                mBinding.verifyEmailButton.setVisibility(View.VISIBLE);
                mBinding.enrollMfa.setVisibility(View.GONE);
            }
        } else {
            mBinding.status.setText(R.string.sign_out);
            mBinding.detail.setText(null);
            mBinding.mfaInfo.setText(null);

            mBinding.emailPasswordButtons.setVisibility(View.VISIBLE);
            mBinding.signedInButtons.setVisibility(View.GONE);
        }
    }

    private void showDisclaimer() {
        new AlertDialog.Builder(this)
                .setTitle("Warning")
                .setMessage("Multi-factor authentication with SMS is currently only available for " +
                        "Google Cloud Identity Platform projects. For more information see: " +
                        "https://cloud.google.com/identity-platform/docs/android/mfa")
                .setPositiveButton("OK", null)
                .show();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.emailSignInButton) {
            startActivityForResult(new Intent(this, signup_details.class), RC_MULTI_FACTOR);
        } else if (i == R.id.signOutButton) {
            signOut();
        } else if (i == R.id.verifyEmailButton) {
            sendEmailVerification();
        } else if (i == R.id.enrollMfa) {
            startActivity(new Intent(this, MultiFactorEnrollActivity.class));
        } else if (i == R.id.unenrollMfa) {
            startActivity(new Intent(this, MultiFactorUnenrollActivity.class));
        } else if (i == R.id.reloadButton) {
            Intent intent = new Intent(MultiFactorActivity.this, signup_details.class);
            startActivity(intent);
        }
    }




}