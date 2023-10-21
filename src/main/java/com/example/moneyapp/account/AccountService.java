package com.example.moneyapp.account;

import com.example.moneyapp.entity.Account;
import com.example.moneyapp.entity.Transaction;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

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

        newAccount.setUserId(userId);
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
                    account.getUserId(),
                    OffsetDateTime.ofInstant(account.getCreatedAt().toInstant(), ZoneId.systemDefault()),
                    OffsetDateTime.ofInstant(account.getUpdatedAt().toInstant(), ZoneId.systemDefault())
            );
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public List<AccountWithTotalDto> getAllAccountWithTotal() {
        try {
            List<Account> accounts = this.accountRepo.findAll();

            return accounts
                    .stream()
                    .map(account -> {
                        double total = 0;
                        for (int i = 0; i < account.getTransactions().size(); i++) {
                            Transaction transaction = account.getTransactions().get(i);
                            Double amount = transaction.getAmount();
                            if (Objects.equals(transaction.getType(), "Expense")) {
                                amount *= -1;
                            }
                            total += amount;
                        }
                        return new AccountWithTotalDto(
                                account.getId(),
                                account.getName(),
                                total
                        );
                    })
                    .collect(toList());
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

}
