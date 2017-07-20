package com.ofg.budgetservice.model;

import javax.persistence.*;
import java.util.Date;

import static java.util.Objects.isNull;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date deletedAt;

    @PrePersist
    private void prePersist() {
        if (isNull(createdAt)) {
            createdAt = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }
}
