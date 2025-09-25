package com.ohgiraffers.mission.b_middle.model;

public class UserDto {
    String name;

    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
