package com.arroz.koh_21.crm.domain.model.commands;

public record CreatePreSetCommand(String productId,
                                  String miraCustomerId,
                                  String shortname,
                                  Double preferredTemperature,
                                  Double preferredDuration,
                                  Double preferredFlow){}
