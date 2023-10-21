package com.example.moneyapp.account;

import com.example.moneyapp.entity.Account;
import com.example.moneyapp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepo;
    private AccountService accountService;
    private AccountMapper accountMapper;
    private UserRepository userRepo;

    public AccountController(AccountRepository accountRepo, AccountService accountService, AccountMapper accountMapper, UserRepository userRepo) {
        this.accountRepo = accountRepo;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.userRepo = userRepo;
    }

    @GetMapping
    @ResponseBody
    public List<AccountDto> listAllAccounts() {
        return accountRepo.findAll()
                .stream()
                .map(accountMapper::toDto)
                .collect(toList());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateAccountDto account) {
        return new ResponseEntity<>(this.accountService.newAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public List<AccountDto> getAccountByUser(@PathVariable(value = "id") Integer id) {
        return accountRepo.findByUserId(id)
                .stream()
                .map(accountMapper::toDto)
                .collect(toList());
    }

    @PutMapping("/{id}/update")
    public AccountDto updateAccount(@PathVariable(value = "id") Integer id, @RequestBody Account account) {
        return this.accountService.updateAccount(id, account);

//        if (response == null) {
//            return new ResponseEntity<>("Account Not Found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
