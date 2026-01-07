package com.techmatrix18.model;

import com.techmatrix18.enums.PaymentMethodType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * Model class representing a PaymentEvent entity.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "payment_events")
public class PaymentEvent {

    @Id
    @Column("id")
    private Long id;

    @Column("payment_id")
    private Long paymentId;                   // Foreign key to Payment

    @Column("event_type")
    private PaymentMethodType eventType;      // Type of the event (e.g., CREATED, UPDATED, FAILED)

    @Column("details")
    private String details;                   // Additional details about the event - JSON or plain text

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;                 // Timestamp of when the event occurred

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public PaymentMethodType getEventType() { return eventType; }
    public void setEventType(PaymentMethodType eventType) { this.eventType = eventType; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentEvent that)) return false;
        return getId().equals(that.getId()) && getPaymentId().equals(that.getPaymentId()) &&
            getEventType() == that.getEventType() && getDetails().equals(that.getDetails());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getPaymentId() != null ? getPaymentId().hashCode() : 0);
        result = 31 * result + (getEventType() != null ? getEventType().hashCode() : 0);
        result = 31 * result + (getDetails() != null ? getDetails().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentEvent {" +
            "id=" + id +
            ", paymentId=" + paymentId +
            ", eventType=" + eventType +
            ", details='" + details + '\'' +
            ", createdAt='" + createdAt + '\'' +
            '}';
    }
}

