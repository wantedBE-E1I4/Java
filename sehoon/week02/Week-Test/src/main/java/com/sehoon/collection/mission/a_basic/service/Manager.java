package com.sehoon.collection.mission.a_basic.service;

import com.ohgiraffers.collection.mission.a_basic.model.Task;

import java.util.List;

public interface Manager <T, R>{
    void add(T t);

    void remove(int id);

    R find(int id);

    void printAll();
}
