package com.techmatrix18.model;

import com.techmatrix18.enums.PaymentMethodType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Model class representing a PaymentMethod entity.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @Column("id")
    private Long id;

    @Column("payment_id")
    private Long paymentId;      // Foreign key to Payment

    @Column("method_type")
    private PaymentMethodType methodType;    // e.g., CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER

    @Column("reference_id")
    private String referenceId;   // e.g., card number (masked), bank account number - card_id | account_id

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public PaymentMethodType getMethodType() { return methodType; }
    public void setMethodType(PaymentMethodType methodType) { this.methodType = methodType; }

    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod that)) return false;
        return getId().equals(that.getId()) && getPaymentId().equals(that.getPaymentId()) &&
                getMethodType().equals(that.getMethodType()) && getReferenceId().equals(that.getReferenceId());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getPaymentId() != null ? getPaymentId().hashCode() : 0);
        result = 31 * result + (getMethodType() != null ? getMethodType().hashCode() : 0);
        result = 31 * result + (getReferenceId() != null ? getReferenceId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentMethod {" +
            "id=" + id +
            ", paymentId=" + paymentId +
            ", methodType='" + methodType + '\'' +
            ", referenceId='" + referenceId + '\'' +
            '}';
    }
}

