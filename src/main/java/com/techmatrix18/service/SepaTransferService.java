package com.techmatrix18.service;

import com.techmatrix18.model.Payment;
import com.techmatrix18.model.SepaTransfer;
import com.techmatrix18.repository.SepaTransferRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service class for managing SEPA transfers.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Service
public class SepaTransferService {
    private SepaTransferRepository sepaTransferRepo;

    public SepaTransferService(SepaTransferRepository sepaTransferRepo) {
        this.sepaTransferRepo = sepaTransferRepo;
    }

    // Business logic methods for managing SEPA transfers can be added here

    public Flux<SepaTransfer> findAll() {
        return sepaTransferRepo.findAll();
    }

    public Mono<SepaTransfer> findById(Long id) {
        return sepaTransferRepo.findById(id);
    }

    public Flux<SepaTransfer> findAllByPaymentId(Long paymentId) {
        return sepaTransferRepo.findAllByPaymentId(paymentId);
    }

    public Flux<SepaTransfer> findAllByDebtorIban(String debtorIban) {
        return sepaTransferRepo.findAllByDebtorIban(debtorIban);
    }

    public Flux<SepaTransfer> findAllByCreditorIban(String creditorIban) {
        return sepaTransferRepo.findAllByCreditorIban(creditorIban);
    }

    public Mono<Boolean> existsByPaymentId(Long paymentId) {
        return sepaTransferRepo.existsByPaymentId(paymentId);
    }

    public Mono<Boolean> existsByPaymentIdAndDebtorIbanAndCreditorIban(
        Long paymentId,
        String debtorIban,
        String creditorIban
    ) {
        return sepaTransferRepo.existsByPaymentIdAndDebtorIbanAndCreditorIban(
            paymentId,
            debtorIban,
            creditorIban
        );
    }

    public Flux<SepaTransfer> findAllByInstantTrue() {
        return sepaTransferRepo.findAllByInstantTrue();
    }
}

