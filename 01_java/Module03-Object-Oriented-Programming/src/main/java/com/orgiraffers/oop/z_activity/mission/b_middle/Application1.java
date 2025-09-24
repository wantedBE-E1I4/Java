package com.orgiraffers.oop.z_activity.mission.b_middle;

public class Application1 {
    public static void main(String[] args) {
        Application1 app = new Application1();
        //각 캐릭터 객체 생성
        Warrior w = new Warrior("강철전사", 200);
        Wizard z = new Wizard("메르린", 100);

        // 같은 메서드라도 각자 다르게 동작
        w.attack();
        z.attack();

        // 실제 객체의 attack() 실행(다형성)
        Character[] party = {w, z};
        for (Character c : party) {
            c.attack();
        }
        z.castSpell();
    }
}
