package com.arroz.koh_21.shared.domain.model.valueObjects;

import jakarta.persistence.Embeddable;


public record Duration(double value) {


    public Duration{
        if(value < 1 || value >240){
            throw new IllegalArgumentException("Duration must be between 1 and 240 minutes.");
        }
    }
}
