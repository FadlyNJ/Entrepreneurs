package com.fadly.entrepreneurs;

public class Forum {

    private Integer image;
    private String title, release, author, content;

    public Forum(Integer image, String title, String release, String author, String content){
        this.image = image;
        this.title = title;
        this.release = release;
        this.content = content;
        this.author = author;
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

    public String getRelease(){
        return release;
    }

    public void setRelease(String release){
        this.release = release;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
