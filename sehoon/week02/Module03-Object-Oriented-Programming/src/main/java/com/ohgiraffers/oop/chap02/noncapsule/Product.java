package com.ohgiraffers.oop.chap02.noncapsule;

public class Product {
    public double payment;

    public String selling(){
        if (payment ==0) {
            return "냅둬유 그냥 개나 주게";
        } else if (payment < 0) {
            return "장사는 뭐더러혀 어차피 넘주는데";
        } else {
            return payment + "예 가지고 가려면 그러든가";
        }
    }
}
