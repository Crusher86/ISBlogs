package ru.innopolis.isblogs.model.entity;

/**
 * Created by Crusher on 30.11.2016.
 */
public class Role extends Model {

    private String name;

    public Role() {
    }

    public Role(int id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
