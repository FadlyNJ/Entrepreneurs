package com.fadly.entrepreneurs;

import android.content.Intent;

public class Article {
    private Integer image;
    private String title;

    public Article(Integer image, String title){
        this.image = image;
        this.title = title;
    }

    public Integer getImage(){
        return image;
    }

    public void setImage(Integer image){
        this.image = image;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

}
