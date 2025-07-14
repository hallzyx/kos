package com.arroz.koh_21.crm.interfaces.resources;

public record CreatePreSetResource(
                                   String shortname,
                                   Double preferredTemperature,
                                   Double preferredDuration,
                                   Double preferredFlow) {
}
