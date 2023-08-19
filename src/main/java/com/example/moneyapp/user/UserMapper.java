package com.example.moneyapp.user;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
class UserMapper {
//    public User toUserUpdate(UserDto userDto) {
//        return new User(userDto.lastName(), userDto.firstName(), userDto.middleName(), new Date());
//    }

    public UserDto toDto(User user) {
        Integer id = user.getId();
        String lastName = user.getLastName();
        String firstName = user.getFirstName();
        String middleName = user.getMiddleName();
        OffsetDateTime createdDate = OffsetDateTime.ofInstant(user.getCreatedAt().toInstant(), ZoneId.systemDefault());
        OffsetDateTime updatedDate = OffsetDateTime.ofInstant(user.getUpdatedAt().toInstant(), ZoneId.systemDefault());

        return new UserDto(id, lastName, firstName, middleName, createdDate, updatedDate);
    }

    public UserAuthDto toTest(User user) {
        return new UserAuthDto(user.getUsername(), user.getPassword());
    }


}
