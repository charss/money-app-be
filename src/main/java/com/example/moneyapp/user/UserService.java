package com.example.moneyapp.user;

import com.example.moneyapp.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Date;
import java.util.Objects;

@Service
public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
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

                OffsetDateTime updatedDate = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
                Date date = Date.from(updatedDate.toInstant());
                user.setUpdatedAt(date);

                this.userRepo.save(user);
            }

            return new UserDto(
                    id,
                    user.getLastName(),
                    user.getFirstName(),
                    user.getMiddleName(),
                    OffsetDateTime.ofInstant(user.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                    OffsetDateTime.ofInstant(user.getUpdatedAt().toInstant(), ZoneId.systemDefault())
            );
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
