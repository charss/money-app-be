package com.example.moneyapp.account;

import com.example.moneyapp.user.User;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public class AccountMapper {

    public AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getUser_id(),
                OffsetDateTime.ofInstant(account.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                OffsetDateTime.ofInstant(account.getUpdatedAt().toInstant(), ZoneId.systemDefault())
        );
    }

}
