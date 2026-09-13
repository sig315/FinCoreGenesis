package com.fincore.fincoregenesis.service;

import com.fincore.fincoregenesis.entity.Account;
import com.fincore.fincoregenesis.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account registerAccount(Account account) {
        account.setCreatedAt(LocalDateTime.now());
        return accountRepository.save(account);
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account depositAccount(Long id, BigDecimal amount) {

        Account account = accountRepository.findById(id).orElse(null);

        if (account == null) {
            return null;
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }

        account.setBalance(account.getBalance().add(amount));

        return accountRepository.save(account);
    }

    public Account withdrawAccount(Long id, BigDecimal amount) {

        Account account = accountRepository.findById(id).orElse(null);

        if (account == null) {
            return null;
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return null;
        }

        if (amount.compareTo(account.getBalance()) > 0) {
            return null;
        }

        account.setBalance(account.getBalance().subtract(amount));

        return accountRepository.save(account);
    }
}