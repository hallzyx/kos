package com.arroz.koh_21.crm.domain.model.valueObjects;



import java.util.UUID;
public record ProductId(UUID value) {

    public ProductId {
        if (value == null) {
            throw new IllegalArgumentException("Product ID cannot be null.");
        }
        if (value.toString().isBlank()) {
            throw new IllegalArgumentException("Product ID cannot be blank.");
        }
        if(UUID.fromString(value.toString()) == null) {
            throw new IllegalArgumentException("Product ID must be a valid UUID.");
        }
    }

}
