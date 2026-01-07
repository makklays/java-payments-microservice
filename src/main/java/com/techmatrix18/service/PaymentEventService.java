package com.techmatrix18.service;

import com.techmatrix18.enums.PaymentEventType;
import com.techmatrix18.model.PaymentEvent;
import com.techmatrix18.model.SepaTransfer;
import com.techmatrix18.repository.PaymentEventRepository;
import com.techmatrix18.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Service class for managing payment events.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class PaymentEventService {
    private PaymentEventRepository paymentEventRepo;

    public PaymentEventService(PaymentEventRepository paymentEventRepo) {
        this.paymentEventRepo = paymentEventRepo;
    }

    // Business logic methods for managing payment events can be added here

    public Flux<PaymentEvent> findAll() {
        return paymentEventRepo.findAll();
    }

    public Mono<PaymentEvent> findById(Long id) {
        return paymentEventRepo.findById(id);
    }

    public Flux<PaymentEvent> findAllByPaymentIdOrderByCreatedAtAsc(Long paymentId) {
        return paymentEventRepo.findAllByPaymentIdOrderByCreatedAtAsc(paymentId);
    }

    public Mono<PaymentEvent> findFirstByPaymentIdOrderByCreatedAtDesc(Long paymentId) {
        return paymentEventRepo.findFirstByPaymentIdOrderByCreatedAtDesc(paymentId);
    }

    public Flux<PaymentEvent> findAllByPaymentIdAndEventType(Long paymentId, PaymentEventType eventType) {
        return paymentEventRepo.findAllByPaymentIdAndEventType(paymentId, eventType);
    }

    public Mono<Boolean> existsByPaymentIdAndEventType(Long paymentId, PaymentEventType eventType) {
        return paymentEventRepo.existsByPaymentIdAndEventType(paymentId, eventType);
    }

    public Flux<PaymentEvent> findAllByCreatedAtBetween(LocalDateTime from, LocalDateTime to) {
        return paymentEventRepo.findAllByCreatedAtBetween(from, to);
    }

    public Flux<PaymentEvent> findAllByPaymentIdAndDetailsContaining(Long paymentId, String text) {
        return paymentEventRepo.findAllByPaymentIdAndDetailsContaining(paymentId, text);
    }
}

