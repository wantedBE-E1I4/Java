package com.ohgiraffers.oop.z_activity.mission.b_middle.model;

public class Wizard extends Character{
    @Override
    public void attack() {
        castSpell();
        System.out.println("화려한 마법으로 공격 !");
    }

    private void castSpell() {
        System.out.println("주문을 시전한다.");
    }
}
