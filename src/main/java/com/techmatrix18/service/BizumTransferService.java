package com.techmatrix18.service;

import com.techmatrix18.model.BizumTransfer;
import com.techmatrix18.repository.BizumTransferRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Service class for managing Bizum transfers.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class BizumTransferService {
    private final BizumTransferRepository bizumTransferRepo;

    public BizumTransferService(BizumTransferRepository bizumTransferRepo) {
        this.bizumTransferRepo = bizumTransferRepo;
    }

    // Business logic methods for managing Bizum transfers can be added here

    public Flux<BizumTransfer> findAll() {
        return bizumTransferRepo.findAll();
    }

    public Mono<BizumTransfer> findById(Long id) {
        return bizumTransferRepo.findById(id);
    }

    public Mono<BizumTransfer> findByPaymentId(Long paymentId) {
        return bizumTransferRepo.findByPaymentId(paymentId);
    }

    public Flux<BizumTransfer> findAllBySenderPhone(String senderPhone) {
        return bizumTransferRepo.findAllBySenderPhone(senderPhone);
    }

    public Flux<BizumTransfer> findAllByReceiverPhone(String receiverPhone) {
        return bizumTransferRepo.findAllByReceiverPhone(receiverPhone);
    }

    public Mono<Boolean> existsByPaymentId(Long paymentId) {
        return bizumTransferRepo.existsByPaymentId(paymentId);
    }

    public Mono<Boolean> existsBySenderPhoneAndReceiverPhoneAndPaymentId(
            String senderPhone,
            String receiverPhone,
            Long paymentId
    ) {
        return bizumTransferRepo.existsBySenderPhoneAndReceiverPhoneAndPaymentId(
                senderPhone,
                receiverPhone,
                paymentId
        );
    }
}

