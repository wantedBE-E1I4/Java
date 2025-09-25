package com.ohgiraffers.mission.b_middle.model;

public class User {
    String name;
    int id;

    public User(String name) {
        this.name = name; // 이걸 안해줘서 "null" 떳음... NPE (X)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
