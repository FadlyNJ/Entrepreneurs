package com.fadly.entrepreneurs;

public class Course {
    private Integer image;
    private String lesson, title, price;

    public Course(Integer image, String title, String lesson, String price){
        this.image = image;
        this.title = title;
        this.price = price;
        this.lesson = lesson;
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

    public String getLesson(){
        return lesson;
    }

    public void setLesson(String lesson){
        this.lesson = lesson;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

}
