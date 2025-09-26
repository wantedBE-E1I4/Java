package com.sehoon.collection.mission.a_basic.service;

import com.ohgiraffers.collection.mission.a_basic.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Manager<String, Task>{
    List<Task> tasks = new ArrayList<>();
    int currentId;

    @Override
    public void add(String content) {
        if (tasks.isEmpty()) {
            currentId = 0;
        } else {
            currentId++;
        }

        Task newTask = new Task(currentId, content);
        tasks.add(newTask);
    }

    @Override
    public void remove(int id) {
        if (tasks.isEmpty()) {
            System.out.println("삭제할 Task가 없습니다.");
        } else {
            // 삭제
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId() == id) {
                    tasks.remove(i);
                    break;
                }
            }
        }
    }

    @Override
    public Task find(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;

    }

    @Override
    public void printAll() {
        System.out.println(this.tasks);
    }

}
