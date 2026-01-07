package com.techmatrix18.repository;

import com.techmatrix18.model.InternalTransfer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Repository interface for Internal entity operations.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Repository
public interface InternalTransferRepository extends ReactiveCrudRepository<InternalTransfer, Long> {

    // Перевод по связанному платежу
    Mono<InternalTransfer> findByPaymentId(Long paymentId);

    // Все переводы, связанные с платежом (если допускается 1:N)
    Flux<InternalTransfer> findAllByPaymentId(Long paymentId);

    // Проверка существования перевода для платежа
    Mono<Boolean> existsByPaymentId(Long paymentId);
}

