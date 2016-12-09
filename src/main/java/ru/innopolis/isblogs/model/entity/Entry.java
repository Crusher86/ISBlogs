package ru.innopolis.isblogs.model.entity;

import java.sql.Date;

/**
 * Created by Crusher on 30.11.2016.
 */
public class Entry {

    private Date date;
    private String entry;
    private int blog_id;

    public Entry() {
    }



    public Date getDate() {
        return date;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
