
package com.gloria.GameKids.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;
@Parcel
public class YoutubeGameSearchResponse {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YoutubeGameSearchResponse() {
    }

    /**
     * 
     * @param kind
     * @param nextPageToken
     * @param pageInfo
     * @param etag
     * @param items
     */
    public YoutubeGameSearchResponse(String kind, String etag, String nextPageToken, List<Item> items, PageInfo pageInfo) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.nextPageToken = nextPageToken;
        this.items = items;
        this.pageInfo = pageInfo;
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

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

}
