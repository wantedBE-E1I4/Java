package com.orgiraffers.oop.z_activity.mission.b_middle;

public class Character {
    public String name;
    public int hp;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    
    public void attack() {
        System.out.println(name + ": 기본 공격!");
    }
}
