package com.example.UserGroup.business.concretes.requests;



public class CreateUserGroupRequests {
    private String group_name;
    public CreateUserGroupRequests(String group_name) {
        this.group_name = group_name;
    }
    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
