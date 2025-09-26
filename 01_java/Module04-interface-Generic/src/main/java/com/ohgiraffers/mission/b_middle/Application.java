package com.ohgiraffers.mission.b_middle;

import com.ohgiraffers.mission.b_middle.model.User;
import com.ohgiraffers.mission.b_middle.model.UserDto;

public class Application {
    public static void main(String[] args) {
        //User로 들어온 name을 UserDto에 넣고 꺼내보자
        User name = new User("냐냐");
        UserToUserDtoConverter userToUserDtoConverter = new UserToUserDtoConverter();
        UserDto convertedName = userToUserDtoConverter.convert(name);
        System.out.println("convertedName = " + convertedName);
    }
}
