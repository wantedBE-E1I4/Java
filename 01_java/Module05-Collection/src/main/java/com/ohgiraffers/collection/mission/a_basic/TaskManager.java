package com.ohgiraffers.collection.mission.a_basic;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String content) {
        int id = nextId++; //id 자동증가

        Task t = new Task(id, content);
        tasks.add(t);
    }
    // 제거
    /*public void removeTask(int id) {
        System.out.println("[DEBUG] before remove: size=" + tasks.size());
        tasks.remove(id);
    }*/
    public boolean removeTask(int id) {
        for (int i = 0; i <tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                return true;
            }
        }
        return false;
    }

    // 조회
    public Task findTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        } return null;
    }
    public void printAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

