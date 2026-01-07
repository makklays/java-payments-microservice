package com.techmatrix18.repository;

import com.techmatrix18.enums.PaymentMethodType;
import com.techmatrix18.model.PaymentMethod;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for PaymentMethod entity operations.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Repository
public interface PaymentMethodRepository extends ReactiveCrudRepository<PaymentMethod, Long> {

    // Найти метод оплаты по связанному платежу
    Mono<PaymentMethod> findByPaymentId(Long paymentId);

    // Все методы оплаты определённого типа
    Flux<PaymentMethod> findAllByMethodType(PaymentMethodType methodType);

    // Проверка существования метода оплаты для платежа
    Mono<Boolean> existsByPaymentId(Long paymentId);

    // Проверка дубликата метода оплаты
    Mono<Boolean> existsByPaymentIdAndMethodType(Long paymentId, PaymentMethodType methodType);

    // Поиск метода оплаты по внешнему идентификатору
    Mono<PaymentMethod> findByReferenceId(String referenceId);
}

