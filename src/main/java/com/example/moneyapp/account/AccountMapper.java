package com.example.moneyapp.account;

import com.example.moneyapp.entity.Account;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Component
public class AccountMapper {

    public AccountDto toDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getUserId(),
                OffsetDateTime.ofInstant(account.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                OffsetDateTime.ofInstant(account.getUpdatedAt().toInstant(), ZoneId.systemDefault())
        );
    }

}
