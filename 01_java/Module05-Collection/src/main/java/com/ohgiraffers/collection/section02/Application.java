package com.ohgiraffers.collection.section02;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 기초 map을 Hash에 넣는다.
 * - hashMap은 키 -값 쌍으로 데이터를 관리하는 컬렉션이다.
 * - 각 키는 유일해야 하며, 중복된 키를 사용할 수 없다. 동일한 키에 대해 값을 변경하면 기존 값이 새 값으로 대체된다.
 * - 실생활 비유: 사전에 단어(키)와 그에 대한 정의(값)을 저장하는 느낌
 * - 데이터의 빠른 검색 및 접근이 가능하며, 키를 통해 직접적으로 값을 조회할 수 있다.
 *
 * - key는 Set이라 중복 허용 X
 * - value는 link라 중복 허용 O
 * - 트리구조
 *
 * hash란?
 * - hash는 데이터를 고정된 크기의 값으로 변환하는 과정을 의미한다. 일반적으로 해시 함수(hash function)을 통해 이루어진다.
 * - 해시 함수는 입력값(예: 키)을 받아 해시 코드(정수)를 생성하며, 이 해시 코드는 hashMap의 내부 배열에서 인덱스로 사용된다.
 * - 해시 코드에 따라 데이터가 배열에 분산되어 저장되므로, 특정 키에 대한 값에 빠르게 접근할 수 있다.
 * - 해시 충돌이란 서로 다른 입력값이 동일한 해시 코드를 생성하는 현상을 말하며 이를 해결하기 위해 다양한 방법 (예: 체이닝, 오픈 어드레싱)이 사용된다.
 * - 해시 함수의 품질이 좋을수록 해시 충돌이 적고, hashMap의 성능이 향상된다.
 *
 * - 체이닝
 * - 오픈 어드레싱: 해시를 받았을때 중복되면 빈공간을 찾아서 넣어버림 (이미지로 보기)
 *
 * HashMap의 주요 특징
 * 1. 키-값 쌍:
 * - hashMap은 데이터를 키와 값으로 구성된 쌍으로 저장하며, 키를 통해 값에 접근할 수 있다.
 * 2. 중복 키 허용 불가
 * - 동일한 키에 대해 새로운 값을 추가하면 기존 값이 대체된다. 따라서 중복된 키를 사용할 수 없다.
 * 3. 순서 없음
 * - hashMap은 내부적으로 해시테이블을 사용하므로, 요소의 순서가 유지되지 않는다.
 * - 요소의 순성를 보장하려면 linkHashMap을 사용할 수 있다.
 * 4. 성능
 * - hashMap은 평균적으로 0(1)의 시간 복잡도로 데이터를 검색, 삽입, 삭제할 수 있다.
 * - 그러나 해시 충돌이 발생하는 최악의 경우 0(n) 시간이 소요될 수 있다.
 * 5. 메모리 사용
 * - HashMap은 해시 테이블을 사용하므로 메모리 사용량이 상대적으로 크다.
 * - 해시 테이블의 크키가 작으면 해시 충돌 발생할 가능성이 높아지므로 적절한 초기 용량과 로드 팩터를 설정하는 것이 좋다.
 */
public class Application {
    public static void main(String[] args) {
        Map<Integer, String> bookMap = new HashMap<>();
        bookMap.put(1, "자바의 정석");
        bookMap.put(2, "클린코드");
        bookMap.put(3, "effective java");

        System.out.println("HashMap : " + bookMap);
        //println 메서드에 오브젝트를 넘겨준다. Object에는 toString이있음. toString은 자기가 가진 필드를 스트링 타입으로 반환하는 함수임
        //내부적으로 toString을 호출하면 요소가 반환될 것을 알 수 있ㄸ다.

        // 요소 접근 //map은 순서를 보장X //index가 아니라key값으로 접근한다.
        String book = bookMap.get(2);
        System.out.println("book = " + book);

        // 요소 삭제
        bookMap.remove(2);
        System.out.println("HashMap : " + bookMap);

        // map 크기
        System.out.println("HashMap = " + bookMap.size());

        System.out.println("책 목록 : ");
        for(Map.Entry<Integer, String> entry : bookMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        if (bookMap.containsKey(3)) {
            System.out.println("키 3의 해당하는 값" + bookMap.get(3));
        } else {
            System.out.println("키 3은 존재하지 않습니다.");
        }
        if (bookMap.containsValue("클린 코드")) {
            System.out.println("클린코드가 존재합니다.");
        } else {
            System.out.println("클린코드는 존재하지 않습니다. ");
        }
    }
}
