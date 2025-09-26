package com.sehoon.collection.mission.a_basic;

import com.ohgiraffers.collection.mission.a_basic.model.Task;
import com.ohgiraffers.collection.mission.a_basic.service.Manager;
import com.ohgiraffers.collection.mission.a_basic.service.TaskManager;

public class Application {
    public static void main(String[] args) {
        // TaskManager 정의
        Manager<String, Task> taskManager = new TaskManager();

        // 할일 삽입
        String[] contents = {"todo1", "todo2", "todo3"};
        for (String content : contents) {
            taskManager.add(content);
        }

        // 삽입 내용 조회
        System.out.println("=== 삽입 내용 조회 ===");
        taskManager.printAll();

        // 할일 삭제
        System.out.println("=== 할일 삭제 ===");
        System.out.println("1번 id를 삭제했습니다.");
        taskManager.remove(1);

        // 할일 찾기
        System.out.println("=== 할일 찾기 ===");
        Task findTask = taskManager.find(1);
        Task findTask2 = taskManager.find(2);
        System.out.println("1번 id를 찾았습니다 : " + findTask);
        System.out.println("2번 id를 찾았습니다 : " + findTask2);

        // 전체 조회
        System.out.println("=== 할일 조회===");
        taskManager.printAll();

        // 새로운 값 추가
        System.out.println("=== 새로운 값 추가 ===");
        taskManager.add("새로운 컨텐츠");

        // id값이 증가하는지 확인
        taskManager.printAll();

    }
}
