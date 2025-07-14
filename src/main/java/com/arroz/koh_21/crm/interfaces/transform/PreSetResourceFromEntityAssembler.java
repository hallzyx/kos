package com.arroz.koh_21.crm.interfaces.transform;

import com.arroz.koh_21.crm.domain.model.aggregates.PreSet;
import com.arroz.koh_21.crm.interfaces.resources.PresetResource;

public class PreSetResourceFromEntityAssembler {
    public static PresetResource ToResourceFromEntity(PreSet entity){
        return new PresetResource(
            entity.getId(),
            entity.getProductId().value().toString(),
            entity.getMiraCustomerId().value().toString(),
            entity.getShortname(),
            entity.getPreferredTemperature().value(),
            entity.getPreferredDuration().value(),
            entity.getPreferredFlow().value()
        );
    }
}
