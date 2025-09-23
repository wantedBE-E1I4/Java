package com.ohgiraffers.oop.chap01.basic2;

/*
* 생성자(Constructor)란 ?
* - 객체를 만들 때 (new로 호출 시) 처음 실행되는 특수한 메서드이다.
* - 클래스 이름과 같고, 반환 타입이 없다.
* - 역할 : 객체의 초기 상태를 설정(필드 값 초기화)
* - 비유 : 자동차 고장에서 차를 만들 때 처음 브랜드와 모델을 붙이는 과정 !
*
* 실생황 예제
* 영화 티켓을 예매할 때, "영화 제목", "좌석 번호"를 초기화 해야한다.
* */
public class Application {
    public static void main(String[] args) {

        // 생성자가 필요한 이유 !
        TicketWithoutConstructor ticket = new TicketWithoutConstructor();
        ticket.printTicket();
        ticket.movieName = "어벤저스";
        ticket.printTicket();
        ticket.seatNumber = "B01";

        System.out.println();
        MovieTicket movieTicket = new MovieTicket("어벤저스","A10");
        movieTicket.printTicket();

        /*
        *
        * */

    }
}
