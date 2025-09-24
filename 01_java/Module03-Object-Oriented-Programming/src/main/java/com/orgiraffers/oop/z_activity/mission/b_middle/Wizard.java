package com.orgiraffers.oop.z_activity.mission.b_middle;

public class Wizard extends Character{

    public Wizard(String name, int hp) {
        super(name, hp);
    }

    @Override
    public void attack() {
        System.out.println(name + ": 화려한 마법으로 공격!");
    }

    public void castSpell() {
        System.out.println(name + ": 파이어볼 시전!");
    }
}
