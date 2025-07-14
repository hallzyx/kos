package com.arroz.koh_21.crm.application.commandServices;

import com.arroz.koh_21.crm.domain.model.aggregates.PreSet;
import com.arroz.koh_21.crm.domain.model.commands.CreatePreSetCommand;
import com.arroz.koh_21.crm.domain.model.valueObjects.MiraCustomerId;
import com.arroz.koh_21.crm.domain.model.valueObjects.ProductId;
import com.arroz.koh_21.crm.domain.services.PreSetCommandService;
import com.arroz.koh_21.crm.infrastructure.persistence.jpa.repositories.PreSetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PreSetCommandServiceImp implements PreSetCommandService {

    private final PreSetRepository preSetRepository;

    public PreSetCommandServiceImp(PreSetRepository preSetRepository) {
        this.preSetRepository = preSetRepository;
    }
    @Override
    public Optional<PreSet> Handle(CreatePreSetCommand command) {

        var productId = new ProductId(UUID.fromString(command.productId()));
        var miraCustomerId = new MiraCustomerId(UUID.fromString(command.miraCustomerId()));


        if(preSetRepository.existsByShortnameAndProductIdAndMiraCustomerId
                (command.shortname(),
                        productId,
                        miraCustomerId
                )){
            throw new IllegalArgumentException(
                    "PreSet with shortname '" + command.shortname() + "' already exists for product '" + command.productId() + "' and customer '" + command.miraCustomerId() + "'.");
        }
        if(preSetRepository.countByMiraCustomerId(miraCustomerId) >= 3){
            throw new IllegalArgumentException("A customer can only have a maximum of 3 presets.");
        }
        var newPreSet = new PreSet(command);
        preSetRepository.save(newPreSet);
        return Optional.of(newPreSet);

    }
}
