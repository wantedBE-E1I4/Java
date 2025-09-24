package com.sehoon.oop.mission.b_middle;

import com.sehoon.oop.mission.b_middle.model.User;
import com.sehoon.oop.mission.b_middle.model.UserDto;
import com.sehoon.oop.mission.b_middle.model.converter.Converter;
import com.sehoon.oop.mission.b_middle.model.converter.StringToIntegerConverter;
import com.sehoon.oop.mission.b_middle.model.converter.UserToUserDtoConverter;

public class Application {
    public static void main(String[] args) {
        Converter<String, Integer> stringConvert = new StringToIntegerConverter();
        Integer converted = stringConvert.convert("-1234");
        if (converted != null) {
            System.out.println(converted);
        }




        // User to UserDto
        User user = new User("12341234", "세훈");
        Converter<User, UserDto> userConverter = new UserToUserDtoConverter();
        UserDto userDto = userConverter.convert(user);

        System.out.println(userDto.getClass());
        System.out.println(userDto.getName());
    }
}
