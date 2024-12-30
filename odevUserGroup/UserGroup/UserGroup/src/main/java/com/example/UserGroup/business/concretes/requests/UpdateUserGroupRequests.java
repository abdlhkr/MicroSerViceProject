package com.example.UserGroup.business.concretes.requests;

public class UpdateUserGroupRequests {
    private int id;
    private String group_name;
    public UpdateUserGroupRequests(int id, String group_name) {
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
