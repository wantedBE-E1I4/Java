package com.orgiraffers.oop.chap01.basic2;

public class MovieTicket {
    String movieName;
    String seatNumber;

    public MovieTicket(String movieName, String seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
    }

    public void printTicket() {
        System.out.println("영화 제목: " + movieName);
        System.out.println("좌석 번호: " + seatNumber);
    }
}
