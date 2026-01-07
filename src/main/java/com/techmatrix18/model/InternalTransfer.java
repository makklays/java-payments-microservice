package com.techmatrix18.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Model class representing an Internal Transfer entity.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "internal_transfers")
public class InternalTransfer {

    @Id
    @Column("id")
    private Long id;

    @Column("payment_id")
    private Long paymentId;         // Foreign key to Payment

    @Column("from_account_id")
    private Long fromAccountId;     // Account ID of the sender

    @Column("to_account_id")
    private Long toAccountId;       // Account ID of the receiver

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getFromAccountId() { return fromAccountId; }
    public void setFromAccountId(Long fromAccountId) { this.fromAccountId = fromAccountId; }

    public Long getToAccountId() { return toAccountId; }
    public void setToAccountId(Long toAccountId) { this.toAccountId = toAccountId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InternalTransfer that)) return false;
        return getId().equals(that.getId()) && getPaymentId().equals(that.getPaymentId()) &&
            getFromAccountId().equals(that.getFromAccountId()) && getToAccountId().equals(that.getToAccountId());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getPaymentId() != null ? getPaymentId().hashCode() : 0);
        result = 31 * result + (getFromAccountId() != null ? getFromAccountId().hashCode() : 0);
        result = 31 * result + (getToAccountId() != null ? getToAccountId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InternalTransfer {" +
            "id=" + id +
            ", paymentId=" + paymentId +
            ", fromAccountId=" + fromAccountId +
            ", toAccountId=" + toAccountId +
            '}';
    }
}

