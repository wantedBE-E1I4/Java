package com.ohgiraffers.collection.mission.a_basic;


/**
 * ### **[기초] Beginner: 할 일 목록(To-Do List) 만들기 (`ArrayList`)**
 *
 * -   **목표**: 순서가 있고 중복을 허용하는 `ArrayList`의 기본적인 데이터 추가, 조회, 수정, 삭제(CRUD) 기능을 익힙니다.
 * -   **요구사항**:
 *     1.  `Task` 클래스를 정의합니다 (필드: `id`(int), `content`(String)).
 *          `id`는 할 일을 고유하게 식별하는 값입니다.
 *     2.  `TaskManager` 클래스에 `ArrayList<Task>`를 멤버 변수로 선언하여 할 일 목록을 관리합니다.
 *     3.  `addTask(String content)`, `removeTask(int id)`, `findTask(int id)`, `printAllTasks()`
 *     메서드를 구현하여 할 일 목록을 관리하는 콘솔 애플리케이션을 만듭니다. `addTask` 시 `id`는 자동으로 증가하도록 구현합니다.
 */
public class Application {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        // id는 자동 증가한다.
        tm.addTask("점심먹기"); //[0]
        tm.addTask("퇴근하기"); //[1]
        tm.addTask("운동가기"); //[2]
        tm.addTask("씻기"); //[3]
        tm.addTask("자기"); //[4]

        tm.printAllTasks();

        System.out.println("제거 후");
        try {
            tm.removeTask(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        tm.printAllTasks();
    }
}
