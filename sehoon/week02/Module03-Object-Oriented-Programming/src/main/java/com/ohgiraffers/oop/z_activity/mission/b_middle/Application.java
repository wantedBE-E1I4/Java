package com.ohgiraffers.oop.z_activity.mission.b_middle;

import com.ohgiraffers.oop.z_activity.mission.b_middle.model.Character;
import com.ohgiraffers.oop.z_activity.mission.b_middle.model.Warrior;
import com.ohgiraffers.oop.z_activity.mission.b_middle.model.Wizard;

public class Application {
    public static void main(String[] args) {

        // 캐릭터 생성
        Character[] characters = {new Warrior(), new Wizard()};

        // 캐릭터별 공격하기
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] instanceof Warrior) {
                characters[i].attack();
            } else if (characters[i] instanceof Wizard) {
                characters[i].attack();
            }
        }
    }
}
