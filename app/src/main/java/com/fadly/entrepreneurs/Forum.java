package com.fadly.entrepreneurs;

public class Forum {

    Integer forumImage;
    String forumTitle, forumRelease, forumAuthor, forumContent;

    public Forum(Integer forumImage, String forumTitle, String forumRelease, String forumAuthor, String forumContent) {
        this.forumImage = forumImage;
        this.forumTitle = forumTitle;
        this.forumRelease = forumRelease;
        this.forumContent = forumContent;
        this.forumAuthor = forumAuthor;
    }

    public Integer getForumImage() {
        return forumImage;
    }

    public void setForumImage(Integer forumImage) {
        this.forumImage = forumImage;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumRelease() {
        return forumRelease;
    }

    public void setForumRelease(String forumRelease) {
        this.forumRelease = forumRelease;
    }

    public String getForumAuthor() {
        return forumAuthor;
    }

    public void setForumAuthor(String forumAuthor) {
        this.forumAuthor = forumAuthor;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }
}
