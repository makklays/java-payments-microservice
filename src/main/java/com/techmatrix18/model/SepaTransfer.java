package com.techmatrix18.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

/**
 * Model class representing a SEPA Transfer entity.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "sepa_transfers")
public class SepaTransfer {

    @Id
    @Column("id")
    private Long id;

    @Column("payment_id")
    private Long paymentId;         // Foreign key to Payment

    @Column("debtor_iban")
    private String debtorIban;      // IBAN отправителя

    @Column("creditor_iban")
    private String creditorIban;    // IBAN получателя

    @Column("creditor_name")
    private String creditorName;    // имя получателя

    @Column("remittance_info")
    private String remittanceInfo;  // назначение платежа

    @Column("instant")
    private Boolean instant;        // Indicates if the transfer is instant - instant / classic

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public String getDebtorIban() { return debtorIban; }
    public void setDebtorIban(String debtorIban) { this.debtorIban = debtorIban; }

    public String getCreditorIban() { return creditorIban; }
    public void setCreditorIban(String creditorIban) { this.creditorIban = creditorIban; }

    public String getCreditorName() { return creditorName; }
    public void setCreditorName(String creditorName) { this.creditorName = creditorName; }

    public String getRemittanceInfo() { return remittanceInfo; }
    public void setRemittanceInfo(String remittanceInfo) { this.remittanceInfo = remittanceInfo; }

    public Boolean getInstant() { return instant; }
    public void setInstant(Boolean instant) { this.instant = instant; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SepaTransfer that)) return false;
        return Objects.equals(id, that.id)
            && Objects.equals(paymentId, that.paymentId)
            && Objects.equals(debtorIban, that.debtorIban)
            && Objects.equals(creditorIban, that.creditorIban)
            && Objects.equals(creditorName, that.creditorName)
            && Objects.equals(remittanceInfo, that.remittanceInfo)
            && Objects.equals(instant, that.instant);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getPaymentId() != null ? getPaymentId().hashCode() : 0);
        result = 31 * result + (getDebtorIban() != null ? getDebtorIban().hashCode() : 0);
        result = 31 * result + (getCreditorIban() != null ? getCreditorIban().hashCode() : 0);
        result = 31 * result + (getCreditorName() != null ? getCreditorName().hashCode() : 0);
        result = 31 * result + (getRemittanceInfo() != null ? getRemittanceInfo().hashCode() : 0);
        result = 31 * result + (getInstant() != null ? getInstant().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SepaTransfer {" +
            "id=" + id +
            ", paymentId=" + paymentId +
            ", debtorIban='" + debtorIban + '\'' +
            ", creditorIban='" + creditorIban + '\'' +
            ", creditorName='" + creditorName + '\'' +
            ", remittanceInfo='" + remittanceInfo + '\'' +
            ", instant=" + instant +
            '}';
    }
}

