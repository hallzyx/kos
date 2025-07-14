package com.arroz.koh_21.shared.domain.model.valueObjects;

import jakarta.persistence.Embeddable;


public record Temperature(double value) {

    public Temperature {
        if (value < 1 || value > 65) {
            throw new IllegalArgumentException("Temperature must be between 1 and 65 degrees Celsius.");
        }
    }

}
