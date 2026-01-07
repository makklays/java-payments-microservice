package com.techmatrix18.model;

import com.techmatrix18.enums.AccountStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Model class representing an Account entity.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 05.01.2026
 */
@Table(name = "accounts")
public class Account {

    @Id
    @Column("id")
    private Long id;                    // Primary key, auto-generated

    @Column("user_id")
    private Long userId;                // User ID

    @Column("iban")
    private String iban;                // Международный номер банковского счета (IBAN)

    @Column("swift_code")
    private String swiftCode;           // SWIFT/BIC код банка (8 или 11 символов)

    @Column("account_type")
    private String accountType;         // тип счета (CHECKING, SAVINGS, BUSINESS)

    @Column("currency_code")
    private String currencyCode;        // валюта счета (USD, EUR…)

    @Column("balance")
    private BigDecimal balance;         // текущий баланс

    @Column("status")
    private AccountStatus status;       // статус счета (ACTIVE, BLOCKED, CLOSED)

    @Column("overdraft_limit")
    private BigDecimal overdraftLimit;  // лимит овердрафта (если есть)

    @Column("owner_name")
    private String ownerName;           // имя владельца счета (если есть)

    @Column("branch_id")
    private Long branchId;              // ID филиала банка (если есть)

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    // --- Getters and Setters ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public String getSwiftCode() { return swiftCode; }
    public void setSwiftCode(String swiftCode) { this.swiftCode = swiftCode; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public AccountStatus getStatus() { return status; }
    public void setStatus(AccountStatus status) { this.status = status; }

    public BigDecimal getOverdraftLimit() { return overdraftLimit; }
    public void setOverdraftLimit(BigDecimal overdraftLimit) { this.overdraftLimit = overdraftLimit; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public Long getBranchId() { return branchId; }
    public void setBranchId(Long branchId) { this.branchId = branchId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return (id != null ? id.equals(account.id) : account.id == null) &&
            (userId != null ? userId.equals(account.userId) : account.userId == null) &&
            (iban != null ? iban.equals(account.iban) : account.iban == null) &&
            (swiftCode != null ? swiftCode.equals(account.swiftCode) : account.swiftCode == null) &&
            (accountType != null ? accountType.equals(account.accountType) : account.accountType == null) &&
            (currencyCode != null ? currencyCode.equals(account.currencyCode) : account.currencyCode == null) &&
            (balance != null ? balance.equals(account.balance) : account.balance == null) &&
            (status != null ? status.equals(account.status) : account.status == null) &&
            (overdraftLimit != null ? overdraftLimit.equals(account.overdraftLimit) : account.overdraftLimit == null) &&
            (ownerName != null ? ownerName.equals(account.ownerName) : account.ownerName == null) &&
            (branchId != null ? branchId.equals(account.branchId) : account.branchId == null);
    }

    @Override
    public int hashCode() {
        int result = 18;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (swiftCode != null ? swiftCode.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (overdraftLimit != null ? overdraftLimit.hashCode() : 0);
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (branchId != null ? branchId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account {" +
            "id=" + id +
            ", userId=" + userId +
            ", iban=" + iban +
            ", swiftCode='" + swiftCode + '\'' +
            ", accountType='" + accountType + '\'' +
            ", currencyCode='" + currencyCode + '\'' +
            ", balance=" + balance +
            ", status='" + status + '\'' +
            ", overdraftLimit=" + overdraftLimit +
            ", ownerName='" + ownerName + '\'' +
            ", branchId=" + branchId +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}

