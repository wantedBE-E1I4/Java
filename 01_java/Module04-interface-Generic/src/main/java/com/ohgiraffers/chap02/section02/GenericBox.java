package com.ohgiraffers.chap02.section02;

public class GenericBox<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
