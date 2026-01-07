package com.techmatrix18.repository;

import com.techmatrix18.model.BizumTransfer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Repository interface for BizumTransfer entity operations.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Repository
public interface BizumTransferRepository extends ReactiveCrudRepository<BizumTransfer, Long> {

    // Найти Bizum-перевод по связанному платежу
    Mono<BizumTransfer> findByPaymentId(Long paymentId);

    // Все переводы, отправленные с телефона
    Flux<BizumTransfer> findAllBySenderPhone(String senderPhone);

    // Все переводы, полученные на телефон
    Flux<BizumTransfer> findAllByReceiverPhone(String receiverPhone);

    // Проверка существования Bizum-перевода для платежа
    Mono<Boolean> existsByPaymentId(Long paymentId);

    // Проверка дубликата Bizum-перевода по отправителю, получателю и платежу
    Mono<Boolean> existsBySenderPhoneAndReceiverPhoneAndPaymentId(
        String senderPhone,
        String receiverPhone,
        Long paymentId
    );
}

