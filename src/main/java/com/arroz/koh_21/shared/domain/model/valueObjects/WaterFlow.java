package com.arroz.koh_21.shared.domain.model.valueObjects;

import jakarta.persistence.Embeddable;


public record WaterFlow(double value) {

    public WaterFlow{
        if (value < 4 || value > 16) {
            throw new IllegalArgumentException("Water flow must be between 4 and 16 L per min.");
        }
    }
}
