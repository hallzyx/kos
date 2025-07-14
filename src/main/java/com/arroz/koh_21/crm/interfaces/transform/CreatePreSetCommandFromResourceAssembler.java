package com.arroz.koh_21.crm.interfaces.transform;

import com.arroz.koh_21.crm.domain.model.commands.CreatePreSetCommand;
import com.arroz.koh_21.crm.interfaces.resources.CreatePreSetResource;

public class CreatePreSetCommandFromResourceAssembler {
    public static CreatePreSetCommand ToCommandFromResource(String productId, String customerId, CreatePreSetResource resource){
        return new CreatePreSetCommand(
            productId,
            customerId,
            resource.shortname(),
            resource.preferredTemperature(),
            resource.preferredDuration(),
            resource.preferredFlow()
        );
    }
}
