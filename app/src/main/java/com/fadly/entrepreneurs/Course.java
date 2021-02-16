package com.fadly.entrepreneurs;

public class Course {
    Integer courseImage;
    String courseLesson, courseTitle, coursePrice;

    public Course(Integer courseImage, String courseTitle, String courseLesson, String coursePrice) {
        this.courseImage = courseImage;
        this.courseTitle = courseTitle;
        this.coursePrice = coursePrice;
        this.courseLesson = courseLesson;
    }

    public Integer getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(Integer courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(String courseLesson) {
        this.courseLesson = courseLesson;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

}
