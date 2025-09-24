package com.orgiraffers.oop.z_activity.mission.b_middle;

public class Warrior extends Character {
    public Warrior(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void attack() {
        System.out.println(name + ": 강력한 칼로 공격!");
    }
}
