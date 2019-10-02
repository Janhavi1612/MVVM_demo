package com.janhavi.android.mvvm_demo.model;

public class Post {
    String name;
    String Id;

    public Post(){
    }

    public Post(String pName, String pId){
        this.name = pName;
        this.Id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
