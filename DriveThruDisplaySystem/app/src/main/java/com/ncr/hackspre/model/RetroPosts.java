package com.ncr.hackspre.model;

import com.google.gson.annotations.*;

public class RetroPosts {

    @SerializedName("usedID")
    private int userID;
    @SerializedName("postID")
    private int postID;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;


    public RetroPosts(final int userID, final int postID, final String title, final String body) {
        this.userID = userID;
        this.postID = postID;
        this.title = title;
        this.body = body;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(final int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(final int postID) {
        this.postID = postID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }
}
