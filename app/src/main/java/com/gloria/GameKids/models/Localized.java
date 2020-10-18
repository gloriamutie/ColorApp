
package com.gloria.GameKids.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Localized {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Localized() {
    }

    /**
     * 
     * @param description
     * @param title
     */
    public Localized(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
