package com.techmatrix18.service;

import com.techmatrix18.enums.PaymentMethodType;
import com.techmatrix18.model.PaymentMethod;
import com.techmatrix18.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service class for managing payment methods.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class PaymentMethodService {
    private PaymentMethodRepository paymentMethodRepo;

    public PaymentMethodService(PaymentMethodRepository paymentMethodRepo) {
        this.paymentMethodRepo = paymentMethodRepo;
    }

    // Business logic methods for managing payment methods can be added here

    public Flux<PaymentMethod> findAll() {
        return paymentMethodRepo.findAll();
    }

    public Mono<PaymentMethod> findById(Long id) {
        return paymentMethodRepo.findById(id);
    }

    public Mono<PaymentMethod> findByPaymentId(Long paymentId) {
        return paymentMethodRepo.findByPaymentId(paymentId);
    }

    public Flux<PaymentMethod> findAllByMethodType(PaymentMethodType methodType) {
        return paymentMethodRepo.findAllByMethodType(methodType);
    }

    public Mono<Boolean> existsByPaymentId(Long paymentId) {
        return paymentMethodRepo.existsByPaymentId(paymentId);
    }

    public Mono<Boolean> existsByPaymentIdAndMethodType(Long paymentId, PaymentMethodType methodType) {
        return paymentMethodRepo.existsByPaymentIdAndMethodType(paymentId, methodType);
    }

    public Mono<PaymentMethod> findByReferenceId(String referenceId) {
        return paymentMethodRepo.findByReferenceId(referenceId);
    }
}

