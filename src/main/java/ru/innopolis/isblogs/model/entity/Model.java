package ru.innopolis.isblogs.model.entity;

import java.io.Serializable;

/**
 * Created by Crusher on 22.11.2016.
 */
public class Model implements Serializable{

    private int id;

    public Model() {

    }

    public Model(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
