package com.ohgiraffers.a_basic;

/**
 * Deep Dive: JVM 메모리 구조
 *
 * JVM의 메모리 구조는 크게 5개 영역으로 나뉜다.
 * 1. Method Area(메서드 영역)
 * - 클래스 정보, Static 변수, 상수 풀 (Constant Pool) 저장
 * 2. Heap(힙)
 * - 객체 및 인스턴스 변수 저장
 * 3. Stack(스택)
 * - 지역 변수, 메서드 호출 시 생성되는 프레임 저장
 * 4. Pc Register(PC  레지스터)
 * - 현재 실행 중인 JVM 명령어의 주소 저장
 * 5. Native Method Stack (네이티브 메소드 스택)
 * - JNT(java Native Interface)에서 ㅅ용하는 네이티브 코드 실행 공간
 * - OS 통신 혹은 고성능 연산과 같은 작업을 위해 자바보다 적합한 언어로 개발된 코드가 저장되는 공간이다.
 *
 * 뭐를 뭐로 칭한다. 자바를 할 때는 알아서 GC가 지운다.
 * os는 C계열 언어. 자바는 C를 이용할 수 없음 os의 바디랭귀지를 저장해놓은 공간
 */
public class MainDeep {
}
