package com.arroz.koh_21.crm.infrastructure.persistence.jpa.repositories;

import com.arroz.koh_21.crm.domain.model.aggregates.PreSet;
import com.arroz.koh_21.crm.domain.model.valueObjects.MiraCustomerId;
import com.arroz.koh_21.crm.domain.model.valueObjects.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PreSetRepository extends JpaRepository<PreSet, Long> {

    Integer countByMiraCustomerId(MiraCustomerId miraCustomerId);

    Boolean existsByShortnameAndProductIdAndMiraCustomerId(String shortname, ProductId productId, MiraCustomerId miraCustomerId);
}
