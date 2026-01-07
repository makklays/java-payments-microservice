package com.techmatrix18.repository;

import com.techmatrix18.enums.PaymentEventType;
import com.techmatrix18.model.PaymentEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Repository interface for PaymentEvent entity operations.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Repository
public interface PaymentEventRepository extends ReactiveCrudRepository<PaymentEvent, Long> {

    // Все события по платежу (история, аудит)
    Flux<PaymentEvent> findAllByPaymentIdOrderByCreatedAtAsc(Long paymentId);

    // Последнее событие по платежу
    Mono<PaymentEvent> findFirstByPaymentIdOrderByCreatedAtDesc(Long paymentId);

    // Все события определённого типа
    Flux<PaymentEvent> findAllByPaymentIdAndEventType(
            Long paymentId,
            PaymentEventType eventType
    );

    // Проверка существования события (идемпотентность)
    Mono<Boolean> existsByPaymentIdAndEventType(
            Long paymentId,
            PaymentEventType eventType
    );

    // Все события в определённом диапазоне дат
    Flux<PaymentEvent> findAllByCreatedAtBetween(
            LocalDateTime from,
            LocalDateTime to
    );

    // Поиск событий по тексту в деталях
    Flux<PaymentEvent> findAllByPaymentIdAndDetailsContaining(
            Long paymentId,
            String text
    );
}

