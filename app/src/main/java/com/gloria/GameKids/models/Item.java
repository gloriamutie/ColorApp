
package com.gloria.GameKids.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("snippet")
    @Expose
    private com.gloria.GameKids.Snippet snippet;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param snippet
     * @param kind
     * @param etag
     * @param id
     */
    public Item(String kind, String etag, String id, com.gloria.GameKids.Snippet snippet) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public com.gloria.GameKids.Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(com.gloria.GameKids.Snippet snippet) {
        this.snippet = snippet;
    }

}