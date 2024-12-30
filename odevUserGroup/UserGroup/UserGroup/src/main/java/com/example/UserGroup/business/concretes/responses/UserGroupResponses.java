package com.example.UserGroup.business.concretes.responses;

public class UserGroupResponses {
    private int id;
    private String group_name;
    public UserGroupResponses() {
    }
    public UserGroupResponses(int id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

