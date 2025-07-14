package com.arroz.koh_21.crm.domain.model.aggregates;

import com.arroz.koh_21.crm.domain.model.commands.CreatePreSetCommand;
import com.arroz.koh_21.crm.domain.model.valueObjects.MiraCustomerId;
import com.arroz.koh_21.crm.domain.model.valueObjects.ProductId;
import com.arroz.koh_21.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.arroz.koh_21.shared.domain.model.valueObjects.Duration;
import com.arroz.koh_21.shared.domain.model.valueObjects.Temperature;
import com.arroz.koh_21.shared.domain.model.valueObjects.WaterFlow;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;


@Getter
@Entity
public class PreSet extends AuditableAbstractAggregateRoot<PreSet> {

    @Embedded
    @AttributeOverride( name = "value", column = @Column(name = "product_id", nullable = false))
    public ProductId productId;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "mira_customer_id", nullable = false))
    public MiraCustomerId miraCustomerId;
    @Column(length = 60, nullable = false)
    public String shortname;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "preferred_temperature", nullable = false))
    public Temperature preferredTemperature;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "preferred_duration", nullable = false))
    public Duration preferredDuration;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "preferred_flow", nullable = false))
    public WaterFlow preferredFlow;

    public PreSet(){}

    public PreSet(CreatePreSetCommand command){

        if(command.shortname() == null || command.shortname().isBlank()) {
            throw new IllegalArgumentException("Shortname cannot be null or blank");
        }

        this.productId = new ProductId(UUID.fromString(command.productId()));
        this.miraCustomerId = new MiraCustomerId(UUID.fromString(command.miraCustomerId()));
        this.shortname = command.shortname();
        this.preferredTemperature = new Temperature(command.preferredTemperature());
        this.preferredDuration = new Duration(command.preferredDuration());
        this.preferredFlow = new WaterFlow(command.preferredFlow());
    }

}
