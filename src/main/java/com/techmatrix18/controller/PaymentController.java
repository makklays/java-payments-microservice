package com.techmatrix18.controller;

import com.techmatrix18.model.Payment;
import com.techmatrix18.service.AccountService;
import com.techmatrix18.service.PaymentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Controller class for handling payment-related HTTP requests.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@RestController
@RequestMapping(path = "/api/v1/payments", produces = "application/json")
@CrossOrigin(origins = "*")
public class PaymentController {
    private PaymentService paymentService;
    private AccountService accountService;

    public PaymentController(PaymentService paymentService, AccountService accountService) {
        this.paymentService = paymentService;
        this.accountService = accountService;
    }

    @GetMapping("/status")
    public String getPaymentStatus() {
        return "Payment service is running.";
    }

    @GetMapping(params = "recent")
    public Flux<Payment> recentPayment() {
        return paymentService.findAll().take(12);
    }

}

