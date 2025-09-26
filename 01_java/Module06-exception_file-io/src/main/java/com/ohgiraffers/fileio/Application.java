package com.ohgiraffers.fileio;

import java.io.*;

/**
 * 파일 입출력과 예외 처리의 기초
 *
 * 파일 입출력은 프로그램에서 데이터를 파일에 저장하거나 읽어오는 기능을 의미한다.
 * 이는 데이터를 영구적으로 보존하거나 외부 데이터를 활용할 때 필수적이다.
 * 예를 들어, 게임에서 점수를 저장하거나 설정 파일을 읽는 상황을 생각해보라
 * 하지만 파일 작업은 외부 자원 (하드디스크, 네트워크 등)에 의존하기 때문에
 * 파일이 없거나 권한 부족 등 예외 상황이 자주 발생한다.
 *
 * 실생활 비유: 파일 입출력은 마치 냉장고에서 음식을 꺼내거나 넣는 것과 같다.
 * 냉장고 문을 열 때 (파일 열기), 음식이 없으면(파일 없음) 배고프거나(예외 발생)
 * 냉장고가 고장 나면(입출력 오류) 요리를 못하게 된다. 이를 대비해 예외 처리가 필요하다.
 *
 * 예외 처리를 하지 않으면? 파일이 없거나 읽기/쓰기 오류가 발생했을 때
 * 프로그램이 강제로 종료되어 사용자 경험이 나빠진다. 반면, 예외 처리를 사용하면
 * 오류를 우아하게 처리하고, 대체 방안을 제시할 수 있다.
 *
 * 심화 개념: 파일 입출력은 자원을 다루므로, 자원을 열도 닫느 ㄴ과정에서
 * 메모리 누수가 발생할 수 있다. 이를 방지하기 위해 JDK7부터 도입된
 * try-with-resources 구문을 사용해 자원을 자동으로 해제한다. //finally없이 리소스 자동으로 닫아줌
 * try(FileWriter writer = new FileWriter("output.txt")) {}
 *
 * 메모리 구조: 파일 입출력 시 데이터는 힙 영역에서 관리되며 file 객체 참조형으러ㅓ
 * 스택에 주소가 저장되고 실제 객체는 힙에 생성된다. 입출력 스트림은 운영체제와 연결되며
 * 성능적으로 버퍼를 사용하는 bufferedReader/Writer가 효율적이다.
 *
 */
public class Application {
    public static void main(String[] args) {
        try(FileWriter writer = new FileWriter("output.txt");) {


            writer.write("hello world");
            writer.write("this is a test file");

            writer.flush(); //버퍼 비움 / 버퍼 열려있음 /버퍼에 잘못된 값이 들어갈 수 있다.
            //버퍼는 열려있고 명령으 을 대기한다. flush() 다음으로writer.write("test") 써줄 수 있다.



            //i/o는 많은 연산이 소모된다. os에 버퍼를 갖는다.
            //텍스트를 버퍼에 저장해놓고 써내려감
            //hello 쓰고 버퍼 비우고 또 world 쓰고 버퍼 비우고
            //스레드가 버퍼 비울때까지 기다린다.
            //스레드와 실행주기가 안맞으면 대기를 걸어준다.



        } catch(IOException e) {
            System.out.println("파일 작성 오류");
        }

        try (FileReader reader = new FileReader("output.txt")) {
            int data;
            while ((data = reader.read()) != -1) { //파일이 끝나면 -1 반환
                System.out.print(data);
                System.out.print(" ");
                System.out.print((char) data + " "); //알팢벳으로 치환될 수 있다.
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
