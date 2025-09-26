package com.sehoon.collection.mission.a_basic.model;

public class Task {
    private int id;
    private String content;

    public Task(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
