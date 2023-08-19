package com.example.moneyapp.user;

import com.example.moneyapp.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private UserRepository userRepo;
    private UserMapper userMapper;

    public UserService(UserRepository userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public UserDto updateUser(Integer id, User updatedUser) {
        try {
            User user = this.userRepo.getReferenceById(id);

            if (!Objects.equals(user.getLastName(), updatedUser.getLastName()) ||
                    !Objects.equals(user.getFirstName(), updatedUser.getFirstName()) ||
                    !Objects.equals(user.getMiddleName(), updatedUser.getMiddleName())
            ) {
                user.setLastName(updatedUser.getLastName());
                user.setFirstName(updatedUser.getFirstName());
                user.setMiddleName(updatedUser.getMiddleName());

                return this.userMapper.toDto(this.userRepo.save(user));
            }

            return this.userMapper.toDto(user);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
