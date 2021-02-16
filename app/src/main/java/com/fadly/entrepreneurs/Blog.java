package com.fadly.entrepreneurs;

public class Blog {

    Integer blogImage;
    String blogTitle, blogDate;

    public Blog(Integer blogImage, String blogTitle, String blogDate) {
        this.blogImage = blogImage;
        this.blogTitle = blogTitle;
        this.blogDate = blogDate;
    }

    public Integer getBlogImage() {
        return blogImage;
    }

    public void setBlogImage(Integer blogImage) {
        this.blogImage = blogImage;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }
}
