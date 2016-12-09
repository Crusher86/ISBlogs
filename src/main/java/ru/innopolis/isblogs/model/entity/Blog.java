package ru.innopolis.isblogs.model.entity;


/**
 * Created by Crusher on 30.11.2016.
 */
public class Blog  {

    private String title;

    public Blog() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private int user_id;

}
