package com.orgiraffers.oop.chap01.basic2;

import java.util.Objects;

public class TicketWithoutConstructor {
    String movieName; //기본 null할당
    String seatNumber;

    public void printTicket() {
        System.out.println("영화 제목: " + movieName);
        System.out.println("좌석 번호: " + seatNumber);
    }

    /**
     * 생성자를 사용하지 않을 경우 발생하는 문제점:
     * 1. 기본값 문제
     * - 클래스의 인스턴스를 생성할 때, 멤버 변수는 자동으로 기본값으로 초기화된다.
     * - String과 같은 참조형 변수는 null로 초기화되며, 이는 나중에 nullPointException을 발생시킬 수 있다.
     * - 예를 들어, movieName이 null인 상태에서 이를 출력하려고 하면 "null"이 출력되거나 해당 변수를 사용하려고 할 때
     *   예외가 발생할 수 있다.
     *
     * 2. 명확한 초기화 부족:
     * - 생성자를 사용하여 초기값을 설정하지 않으면, 인스턴스가 생성된 후
     *   반드시 각 변수를 수동으로 초기화해야한다. 이는 코드의 가독성을 떨어뜨리고,
     *   실수로 초기화를 누락할 가능성을 높인다.
     *
     * 3. 불변성 유지 어려움
     * - 객체가 생성될 때 필요한 데이터를 모두 초기화하지 않으면, 이후에 객체의 상태가 일관되지 않거나
     *   불완전한 상태로 남아있을 수 있다.
     *   생성자를 통해 모든 필수 정보를 초기화하는 것이 객체의 불변성을 유지하는데 도움이 된다.
     *    * 불변성이란 상태가 한 번 설정되면 변경되지 않는 것을 의미한다.
     *
     * 따라서, 생성자를 사용하여 객체의 초기 상태를 명확하게 정의하는 것이 중요하다.
     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TicketWithoutConstructor that = (TicketWithoutConstructor) o;
        return Objects.equals(movieName, that.movieName) && Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, seatNumber);
    }
}
