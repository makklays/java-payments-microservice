package com.techmatrix18.repository;

import com.techmatrix18.model.SepaTransfer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Repository interface for SepaTransfer entity operations.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Repository
public interface SepaTransferRepository extends ReactiveCrudRepository<SepaTransfer, Long> {

    // Найти все переводы по платежу
    Flux<SepaTransfer> findAllByPaymentId(Long paymentId);

    // Найти все переводы с конкретного счета (отправителя)
    Flux<SepaTransfer> findAllByDebtorIban(String debtorIban);

    // Найти все переводы на конкретный счет (получателя)
    Flux<SepaTransfer> findAllByCreditorIban(String creditorIban);

    // Проверка существования перевода для платежа
    Mono<Boolean> existsByPaymentId(Long paymentId);

    // Проверка дубликата по счетам и платежу
    Mono<Boolean> existsByPaymentIdAndDebtorIbanAndCreditorIban(
        Long paymentId,
        String debtorIban,
        String creditorIban
    );

    // Найти все мгновенные переводы
    Flux<SepaTransfer> findAllByInstantTrue();
}

