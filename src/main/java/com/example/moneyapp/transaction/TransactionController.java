package com.example.moneyapp.transaction;

import com.example.moneyapp.account.AccountRepository;
import com.example.moneyapp.category.CategoryRepository;
import com.example.moneyapp.entity.Account;
import com.example.moneyapp.entity.Category;
import com.example.moneyapp.entity.Transaction;
import com.example.moneyapp.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepo;
    private TransactionMapper transactionMapper;
    private TransactionService transactionService;
    private AccountRepository accountRepo;
    private CategoryRepository categoryRepo;

    public TransactionController(TransactionRepository transactionRepo, TransactionMapper transactionMapper, TransactionService transactionService, AccountRepository accountRepo, CategoryRepository categoryRepo) {
        this.transactionRepo = transactionRepo;
        this.transactionMapper = transactionMapper;
        this.transactionService = transactionService;
        this.accountRepo = accountRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    @ResponseBody
//    public void getTransactions() {
    public List<TransactionDto> getTransactions() {
//        this.transactionService.findAll();
        return this.transactionRepo.findAll()
                .stream()
                .map(transactionMapper::toDto)
                .collect(toList());
    }

    @GetMapping("/test")
    @ResponseBody
    public void test() {
        List<Transaction> test = this.transactionRepo.findAll();
        System.out.println(test.get(1).getAmount());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<TransactionDto> findTransactionById(@PathVariable(value="id") Integer id) {
        return Optional.of(this.transactionMapper.toDto(this.transactionRepo.getReferenceById(id)));
    }

//    @GetMapping("/category/{id}")
//    @ResponseBody
//    public List<TransactionDto> getTransactionsByCategory(@PathVariable(value="id") Integer id) {
//        return transactionRepo.findByCategoryId(id)
//                .stream()
//                .map(transactionMapper::toDto)
//                .collect(toList());
//    }

    @GetMapping("/account/{id}")
    @ResponseBody
    public List<TransactionDto> findTransactionsByAccountId(@PathVariable(value="id") Integer id) {
//    public void getTransactionsByAccount(@PathVariable(value="id") Integer id) {
//        System.out.println(this.transactionRepo.findByAccountId(id));
        return this.transactionRepo.findByAccountId(id)
                .stream()
                .map(this.transactionMapper::toDto)
                .toList();
    }

    @GetMapping("/type/{type}")
    @ResponseBody
    public List<TransactionDto> getTransactionsByType(@PathVariable(value="type") String type) {
        return transactionRepo.findByType(type)
                .stream()
                .map(transactionMapper::toDto)
                .collect(toList());
    }

    @PostMapping
    @ResponseBody
    public void add(@RequestBody CreateTransactionDto createTransactionDto) {
//    public ResponseEntity<?> add(@RequestBody CreateTransactionDto createTransactionDto) {
//        Account fetchAccount = new Account(this.accountRepo.getReferenceById(25));
        this.transactionService.add(createTransactionDto);
//        System.out.println(createTransactionDto);

//        System.out.println(test);
//        System.out.println(Optional.of(this.accountMapper.toDto(this.accountRepo.getReferenceById(id))));
//        Account account = this.accountRepo.getReferenceById(25);
//        try {
//            var accounts = this.accountRepo.findAll();
//            System.out.println(accounts);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        var account = this.accountRepo.findByAcc(25);


//        System.out.println("ADD");
//        System.out.println(createTransactionDto.accountId());
//
////        Optional<Account> account = this.accountRepo.findById(createTransactionDto.accountId());
//        Category category = this.categoryRepo.getReferenceById(createTransactionDto.categoryId());
//
//        Transaction transaction = new Transaction();
//        System.out.println("HERE 1");
//        System.out.println(transaction);
//        transaction.setAccount(account);
//        System.out.println("AFTER ACCOUNT");
//        System.out.println(transaction);
//        transaction.setAmount(createTransactionDto.amount());
//        transaction.setType(createTransactionDto.type());
//        transaction.setCategory(category);
//
//        System.out.println("HERE");
//        System.out.println(transaction);

//        return new ResponseEntity<>(this.transactionRepo.save(transaction), HttpStatus.CREATED);
    }
}
