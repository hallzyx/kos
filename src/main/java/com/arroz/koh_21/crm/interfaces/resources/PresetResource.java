package com.arroz.koh_21.crm.interfaces.resources;

public record PresetResource(Long Int,
                             String productId,
                             String miraCustomerId,
                             String shortname,
                             Double preferredTemperature,
                             Double preferredDuration,
                             Double preferredFlow) {
}
