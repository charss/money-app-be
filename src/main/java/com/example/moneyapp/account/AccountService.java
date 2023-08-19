package com.example.moneyapp.account;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Service
public class AccountService {
    private AccountRepository accountRepo;

    public AccountService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account newAccount(CreateAccountDto createAccountDto) {
        String name = createAccountDto.name();
        Integer userId = createAccountDto.userId();

        Account newAccount = new Account();

        newAccount.setUser_id(userId);
        newAccount.setName(name);


        return this.accountRepo.save(newAccount);
    }

    public AccountDto updateAccount(Integer id, Account updatedAccount) {
        try {
            Account account = this.accountRepo.getReferenceById(id);

            if (!Objects.equals(account.getName(), updatedAccount.getName())) {
                account.setName(updatedAccount.getName());

                OffsetDateTime updatedDate = OffsetDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
                Date date = Date.from(updatedDate.toInstant());
                account.setUpdatedAt(date);

                this.accountRepo.save(account);
            }

            return new AccountDto(
                    id,
                    account.getName(),
                    account.getUser_id(),
                    OffsetDateTime.ofInstant(account.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                    OffsetDateTime.ofInstant(account.getUpdatedAt().toInstant(), ZoneId.systemDefault())
            );
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
