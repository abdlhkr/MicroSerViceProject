package com.example.UserGroup.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "user_group")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "group_name")
    private String group_name;

    public int getId() {
        return id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
