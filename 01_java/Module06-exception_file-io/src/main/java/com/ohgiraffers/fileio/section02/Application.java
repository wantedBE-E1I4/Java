package com.ohgiraffers.fileio.section02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // writer.writer("test");
        // 파일라이터는 "test"를 바러 넣음 hdd에 바로 저장 // 즉시 즉시 하기땜누에 한번의 라인당 100번 i/o
        // 버퍼리더라이터는 라이ㅓㅌ 기능이 들어오면 "test"값을 자바 애플레이션에다가 앱 내부에 임시 버퍼를 만들고 담느낟.
        //메모리 상으로 동작시켜서 느리지 않다.
        //50줄까지 적재가능하면 묶어서 저장-> 적재->넘김 2번 i/o -> i/o를 최소한으로 줄임
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("user_input.txt"));
            Scanner sc = new Scanner(System.in)) {

            System.out.println("입력 값: ");
            String message = sc.nextLine();
            writer.write("사용자 입력: " + message);
            writer.newLine();
            writer.write("작성 시간: " + java.time.LocalDate.now());
            writer.flush();
            System.out.println("파일에 데이터 저장 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
