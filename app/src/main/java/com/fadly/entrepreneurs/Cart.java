package com.fadly.entrepreneurs;

public class Cart {
    Integer courseImage;
    String courseTitle, coursePrice, courseQuantity;

    public Cart(Integer courseImage, String coursePrice, String courseQuantity, String courseTitle) {
        this.courseImage = courseImage;
        this.coursePrice = coursePrice;
        this.courseQuantity = courseQuantity;
        this.courseTitle = courseTitle;
    }

    public Integer getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(Integer courseImage) {
        this.courseImage = courseImage;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseQuantity() {
        return courseQuantity;
    }

    public void setCourseQuantity(String courseQuantity) {
        this.courseQuantity = courseQuantity;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
