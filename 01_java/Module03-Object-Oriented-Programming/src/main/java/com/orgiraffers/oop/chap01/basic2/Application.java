package com.orgiraffers.oop.chap01.basic2;

/**
 * 생성자(Constructor)란?
 * - 객체를 만들 때(new로 호출 시) 처음 실행되는 특수한 메서드이다.
 * - 클래스 이름과 같고, 반환 타입이 없다.
 * - 역할: 객체의 초기 상태를 설정(필드 값 초기화)
 * - 비유: 자동차 공장에서 차를 만들 때 처음 브랜드와 모델을 붙이는 과정!
 *
 * 실생활 예제
 * 영화 티켓을 예매할 때, "영화 제목", "좌석 번호"를 초기화해야 한다.
 */
public class Application {
    public static void main(String[] args) {
        TicketWithoutConstructor ticket = new TicketWithoutConstructor(); //TicketWithoutConstructor
        ticket.printTicket();

        ticket.movieName = "어벤져스";
        ticket.printTicket();
        ticket.seatNumber = "B10";
        System.out.println();

        //MovieTicket movieTicket = new MovieTicket(); //매개변수 2개 필요 //필요한 재료가 없으니 난 실행하지 않아
        MovieTicket movieTicket = new MovieTicket("어벤져스", "A10"); //강제화
        movieTicket.printTicket();

        /*MovieTicket movieTicket = new MovieTicket(); //기본 생성자
        movieTicket.printTicket();*/
    }
}
