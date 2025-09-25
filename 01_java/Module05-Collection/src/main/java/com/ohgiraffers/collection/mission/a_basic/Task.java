package com.ohgiraffers.collection.mission.a_basic;

public class Task {
    private String content;
    public int id;

    public Task(int id, String content) {
        this.content = content;
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
