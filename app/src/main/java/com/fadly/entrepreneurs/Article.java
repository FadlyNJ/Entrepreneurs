package com.fadly.entrepreneurs;

public class Article {
    Integer articleImage;
    String articleTitle;

    public Article(Integer articleImage, String articleTitle) {
        this.articleImage = articleImage;
        this.articleTitle = articleTitle;
    }

    public Integer getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(Integer articleImage) {
        this.articleImage = articleImage;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

}
