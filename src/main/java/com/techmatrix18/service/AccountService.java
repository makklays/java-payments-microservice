package com.techmatrix18.service;

import com.techmatrix18.enums.AccountStatus;
import com.techmatrix18.model.Account;
import com.techmatrix18.repository.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Service class for managing accounts.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Business logic methods for managing accounts can be added here

    public Flux<Account> findAll() {
        return accountRepository.findAll();
    }

    public Mono<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    public Flux<Account> findAllByUserId(Long userId) {
        return accountRepository.findAllByUserId(userId);
    }

    public Mono<Account> findByIban(String iban) {
        return accountRepository.findByIban(iban);
    }

    public Mono<Boolean> existsByIban(String iban) {
        return accountRepository.existsByIban(iban);
    }

    public Mono<Account> findByUserIdAndIban(Long userId, String iban) {
        return accountRepository.findByUserIdAndIban(userId, iban);
    }

    public Flux<Account> findAllByCurrencyCode(String currencyCode) {
        return accountRepository.findAllByCurrencyCode(currencyCode);
    }

    public Mono<Boolean> existsByUserId(Long userId) {
        return accountRepository.existsByUserId(userId);
    }

    Flux<Account> findAllByUserIdAndStatus(Long userId, AccountStatus status) {
        return accountRepository.findAllByUserIdAndStatus(userId, status);
    }

    Flux<Account> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to) {
        return accountRepository.findAllByCreatedAtBetween(from, to);
    }
}

