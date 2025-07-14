package com.arroz.koh_21.crm.domain.services;

import com.arroz.koh_21.crm.domain.model.aggregates.PreSet;
import com.arroz.koh_21.crm.domain.model.commands.CreatePreSetCommand;

import java.util.Optional;

public interface PreSetCommandService {

    Optional<PreSet> Handle(CreatePreSetCommand command);
}
