package com.mahi.javapassion.shipmentservice.commoand.api.repository;

import com.mahi.javapassion.shipmentservice.commoand.api.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<ShipmentEntity, String> {
}
