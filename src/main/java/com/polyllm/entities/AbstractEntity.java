package com.polyllm.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {


    @Serial
    private static final long serialVersionUID = 4321220625746217297L;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant created;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updated;

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() {
        return updated;
    }

}

