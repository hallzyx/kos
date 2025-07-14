package com.arroz.koh_21.crm.domain.model.valueObjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

public record MiraCustomerId(UUID value) {

    public MiraCustomerId {
        if (value == null) {
            throw new IllegalArgumentException("Mira Customer ID cannot be null.");
        }
    }

}
