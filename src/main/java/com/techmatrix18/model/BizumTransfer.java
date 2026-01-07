package com.techmatrix18.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Model class representing a Bizum Transfer entity (Spain).
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "bizum_transfers")
public class BizumTransfer {

    @Id
    @Column("id")
    private Long id;

    @Column("payment_id")
    private Long paymentId;         // Foreign key to Payment

    @Column("sender_phone")
    private String senderPhone;     // Phone number of the sender

    @Column("receiver_phone")
    private String receiverPhone;   // Phone number of the receiver

    @Column("concept")
    private String concept;         // описание

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public String getSenderPhone() { return senderPhone; }
    public void setSenderPhone(String senderPhone) { this.senderPhone = senderPhone; }

    public String getReceiverPhone() { return receiverPhone; }
    public void setReceiverPhone(String receiverPhone) { this.receiverPhone = receiverPhone; }

    public String getConcept() { return concept; }
    public void setConcept(String concept) { this.concept = concept; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BizumTransfer that)) return false;
        return getId().equals(that.getId()) && getPaymentId().equals(that.getPaymentId()) &&
            getSenderPhone().equals(that.getSenderPhone()) && getReceiverPhone().equals(that.getReceiverPhone()) &&
            getConcept().equals(that.getConcept());
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getPaymentId() != null ? getPaymentId().hashCode() : 0);
        result = 31 * result + (getSenderPhone() != null ? getSenderPhone().hashCode() : 0);
        result = 31 * result + (getReceiverPhone() != null ? getReceiverPhone().hashCode() : 0);
        result = 31 * result + (getConcept() != null ? getConcept().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BizumTransfer {" +
            "id=" + id +
            ", paymentId=" + paymentId +
            ", senderPhone='" + senderPhone + '\'' +
            ", receiverPhone='" + receiverPhone + '\'' +
            ", concept='" + concept + '\'' +
            '}';
    }
}

