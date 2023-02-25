package com.mahi.javapassion.shipmentservice.commoand.api.event;

import com.mahi.javapassion.commonservice.event.OrderShippedEvent;
import com.mahi.javapassion.shipmentservice.commoand.api.entity.ShipmentEntity;
import com.mahi.javapassion.shipmentservice.commoand.api.repository.ShipmentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ShipmentEventHandler {

    private ShipmentRepository shipmentRepository;

    public ShipmentEventHandler(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @EventHandler
    public void on(OrderShippedEvent orderShippedEvent) {
        ShipmentEntity entity = ShipmentEntity.builder()
                .shipmentId(orderShippedEvent.getShipmentId())
                .orderId(orderShippedEvent.getOrderId())
                .shipmentDate(LocalDate.now())
                .shipmentStatus(orderShippedEvent.getShipmentStatus())
                .build();
        shipmentRepository.save(entity);
    }
}
