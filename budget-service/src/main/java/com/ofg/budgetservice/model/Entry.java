package com.ofg.budgetservice.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Entry extends BaseEntity {

    public enum EntryType {
        EXPENSE, INCOME;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRANSACTION_ID")
    private Transaction transaction;

    @Enumerated(EnumType.STRING)
    private EntryType type;

    private BigDecimal amount;

    Entry() {
    }

    public Entry(EntryType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
