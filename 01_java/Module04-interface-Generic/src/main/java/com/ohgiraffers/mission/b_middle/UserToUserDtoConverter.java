package com.ohgiraffers.mission.b_middle;

import com.ohgiraffers.mission.b_middle.model.User;
import com.ohgiraffers.mission.b_middle.model.UserDto;

public class UserToUserDtoConverter implements Converter<User, UserDto> {
    //매칭됨 User, UserDto
    @Override
    public UserDto convert(User user) {
        return new UserDto(user.getName());
    }
}
