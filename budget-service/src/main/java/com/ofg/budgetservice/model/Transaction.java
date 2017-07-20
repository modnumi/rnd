package com.ofg.budgetservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Collections.unmodifiableList;

@Entity
public class Transaction extends BaseEntity {

    private String comment;

    @Temporal(TemporalType.DATE)
    private Date when;

    @OneToMany(mappedBy = "transaction", fetch = FetchType.EAGER)
    private List<Entry> entries = new ArrayList<>();

    Transaction() {
    }

    public Transaction(String comment, Date when) {
        this.comment = comment;
        this.when = when;
    }

    public void addEntry(Entry entry) {
        entry.setTransaction(this);
        entries.add(entry);
    }

    public String getComment() {
        return comment;
    }

    public Date getWhen() {
        return when;
    }

    public List<Entry> getEntries() {
        return unmodifiableList(entries);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", comment='" + comment + '\'' +
                ", when=" + when +
                ", entries=" + entries +
                '}';
    }
}
