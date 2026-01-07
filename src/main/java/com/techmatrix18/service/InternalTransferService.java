package com.techmatrix18.service;

import com.techmatrix18.model.InternalTransfer;
import com.techmatrix18.repository.InternalTransferRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Service class for managing internal transfers.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class InternalTransferService {
    private final InternalTransferRepository internalTransferRepo;

    public InternalTransferService(InternalTransferRepository internalTransferRepo) {
        this.internalTransferRepo = internalTransferRepo;
    }

    // Business logic methods for managing internal transfers can be added here

    public Flux<InternalTransfer> findAll() {
        return internalTransferRepo.findAll();
    }

    public Mono<InternalTransfer> findById(Long id) {
        return internalTransferRepo.findById(id);
    }

    public Mono<InternalTransfer> save(InternalTransfer internalTransfer) {
        return internalTransferRepo.save(internalTransfer);
    }

    public Mono<InternalTransfer> findByPaymentId(Long paymentId) {
        return internalTransferRepo.findByPaymentId(paymentId);
    }

    public Flux<InternalTransfer> findAllByPaymentId(Long paymentId) {
        return internalTransferRepo.findAllByPaymentId(paymentId);
    }

    public Mono<Boolean> existsByPaymentId(Long paymentId) {
        return internalTransferRepo.existsByPaymentId(paymentId);
    }
}

