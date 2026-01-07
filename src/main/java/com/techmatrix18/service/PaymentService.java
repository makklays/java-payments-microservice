package com.techmatrix18.service;

import com.techmatrix18.enums.PaymentStatus;
import com.techmatrix18.enums.PaymentType;
import com.techmatrix18.model.Payment;
import com.techmatrix18.repository.AccountRepository;
import com.techmatrix18.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Service class for managing payments.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;

    public PaymentService(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    // Business logic methods for managing payments can be added here

    public Flux<Payment> findAll() {
        return paymentRepo.findAll();
    }

    public Mono<Payment> findById(Long id) {
        return paymentRepo.findById(id);
    }

    public Flux<Payment> findAllByUserId(Long userId) {
        return paymentRepo.findAllByUserId(userId);
    }

    public Flux<Payment> findAllByUserIdAndStatus(Long userId, PaymentStatus status) {
        return paymentRepo.findAllByUserIdAndStatus(userId, status);
    }

    public Flux<Payment> findAllByType(PaymentType type) {
        return paymentRepo.findAllByType(type);
    }

    public Mono<Boolean> existsByExternalId(String externalId) {
        return paymentRepo.existsByExternalId(externalId);
    }

    public Mono<Payment> findByExternalId(String externalId) {
        return paymentRepo.findByExternalId(externalId);
    }

    public Flux<Payment> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to) {
        return paymentRepo.findAllByCreatedAtBetween(from, to);
    }

    public Flux<Payment> findAllByUserIdAndCreatedAtBetween(Long userId, LocalDateTime from, LocalDateTime to) {
        return paymentRepo.findAllByUserIdAndCreatedAtBetween(userId, from, to);
    }
}

