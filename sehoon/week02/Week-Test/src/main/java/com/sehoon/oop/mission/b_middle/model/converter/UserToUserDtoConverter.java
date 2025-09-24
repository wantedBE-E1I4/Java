package com.sehoon.oop.mission.b_middle.model.converter;

import com.sehoon.oop.mission.b_middle.model.User;
import com.sehoon.oop.mission.b_middle.model.UserDto;

public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        UserDto userDto = new UserDto(user.getName());
        return userDto;
    }
}
