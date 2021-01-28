package com.fadly.entrepreneurs;

public class Blog {

    private Integer image;
    private String title, date;

    public Blog(Integer image, String title, String date){
        this.image = image;
        this.title = title;
        this.date = date;
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

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
}
