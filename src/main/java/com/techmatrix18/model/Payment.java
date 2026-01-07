package com.techmatrix18.model;

import com.techmatrix18.enums.PaymentStatus;
import com.techmatrix18.enums.PaymentType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model class representing a Payment entity.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "payments")
public class Payment {

    @Id
    @Column("id")
    private Long id;

    @Column("external_id")
    private String externalId;       // Это внешний идентификатор платежа, используемый для интеграции с внешними системами

    @Column("user_id")
    private Long userId;

    @Column("type")
    private PaymentType type;

    @Column("status")
    private PaymentStatus status;    // статус платежа (PENDING, COMPLETED, FAILED)

    @Column("amount")
    private BigDecimal amount;

    @Column("currency_code")
    private String currencyCode;

    @Column("exchange_rate")
    private BigDecimal exchangeRate;  // обменный курс, если применимо

    @Column("fee_amount")
    private BigDecimal feeAmount;     // комиссия за обработку платежа

    @Column("total_amount")
    private BigDecimal totalAmount;   // общая сумма (amount + feeAmount)

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("executed_at")
    private LocalDateTime executedAt;

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public PaymentType getType() { return type; }
    public void setType(PaymentType type) { this.type = type; }

    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public BigDecimal getExchangeRate() { return exchangeRate; }
    public void setExchangeRate(BigDecimal exchangeRate) { this.exchangeRate = exchangeRate; }

    public BigDecimal getFeeAmount() { return feeAmount; }
    public void setFeeAmount(BigDecimal feeAmount) { this.feeAmount = feeAmount; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getExecutedAt() { return executedAt; }
    public void setExecutedAt(LocalDateTime executedAt) { this.executedAt = executedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return getId().equals(payment.getId()) && getExternalId().equals(payment.getExternalId()) &&
            getUserId().equals(payment.getUserId()) && getType() == payment.getType() &&
            getStatus() == payment.getStatus() && getAmount().equals(payment.getAmount()) &&
            getCurrencyCode().equals(payment.getCurrencyCode()) && getExchangeRate().equals(payment.getExchangeRate()) &&
            getFeeAmount().equals(payment.getFeeAmount()) && getTotalAmount().equals(payment.getTotalAmount());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (exchangeRate != null ? exchangeRate.hashCode() : 0);
        result = 31 * result + (feeAmount != null ? feeAmount.hashCode() : 0);
        result = 31 * result + (totalAmount != null ? totalAmount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payment {" +
            "id=" + id +
            ", externalId='" + externalId + '\'' +
            ", userId=" + userId +
            ", type=" + type +
            ", status=" + status +
            ", amount=" + amount +
            ", currencyCode='" + currencyCode + '\'' +
            ", exchangeRate=" + exchangeRate +
            ", feeAmount=" + feeAmount +
            ", totalAmount=" + totalAmount +
            ", createdAt=" + createdAt +
            ", executedAt=" + executedAt +
            '}';
    }
}

