package com.janhavi.android.mvvm_demo.model;

public class Upload {
    private String post;
    private String imageUrl;
    private boolean imagePresent;
    private String userName;

    public Upload() {
        this.post="";
        this.imageUrl="";
        this.imagePresent=true;
        this.userName="PICT_TEJ";
    }


    public Upload(String post, String imageUrl) {
        if (post.trim().equals("")) {
            this.post = "No name";
        }
        if(imageUrl.trim().equals("")){
            imagePresent = false;
        }
        else
            imagePresent = true;
        this.post = post;
        this.imageUrl = imageUrl;
        this.userName="PICT_TEJ";
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isImagePresent() {
        return imagePresent;
    }

    public void setImagePresent(boolean imagePresent) {
        this.imagePresent = imagePresent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
