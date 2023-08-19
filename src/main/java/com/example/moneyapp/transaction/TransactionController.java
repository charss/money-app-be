package com.example.moneyapp.transaction;

import com.example.moneyapp.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepo;
    private TransactionMapper transactionMapper;

    public TransactionController(TransactionRepository transactionRepo, TransactionMapper transactionMapper) {
        this.transactionRepo = transactionRepo;
        this.transactionMapper = transactionMapper;
    }

    @GetMapping
    @ResponseBody
    public List<TransactionDto> getTransactions() {
        return transactionRepo.findAll()
                .stream()
                .map(transactionMapper::toDto)
                .collect(toList());
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public List<TransactionDto> getTransactionsByCategory(@PathVariable(value="id") Integer id) {
        return transactionRepo.findByCategoryId(id)
                .stream()
                .map(transactionMapper::toDto)
                .collect(toList());
    }

    @GetMapping("/account/{id}")
    @ResponseBody
    public List<TransactionDto> getTransactionsByAccount(@PathVariable(value="id") Integer id) {
        return transactionRepo.findByAccountId(id)
                .stream()
                .map(transactionMapper::toDto)
                .collect(toList());
    }

    @GetMapping("/type/{type}")
    @ResponseBody
    public List<TransactionDto> getTransactionsByType(@PathVariable(value="type") String type) {
        return transactionRepo.findByType(type)
                .stream()
                .map(transactionMapper::toDto)
                .collect(toList());
    }
}
