package com.mahi.javapassion.shipmentservice.commoand.api.aggregate;

import com.mahi.javapassion.commonservice.command.ShipOrderCommand;
import com.mahi.javapassion.commonservice.event.OrderShippedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ShipmentAggregate {
    @AggregateIdentifier
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

    public ShipmentAggregate() {}

    @CommandHandler
    public ShipmentAggregate(ShipOrderCommand shipOrderCommand) {
        //Validate Shipment Details`
        //Publish Order Shipped Event
        OrderShippedEvent orderShippedEvent = OrderShippedEvent.builder()
                .shipmentId(shipOrderCommand.getShipmentId())
                .orderId(shipOrderCommand.getOrderId())
                .shipmentStatus("SHIPPED")
                .build();
        AggregateLifecycle.apply(orderShippedEvent);
    }

    @EventSourcingHandler
    public void on(OrderShippedEvent orderShippedEvent) {
        this.shipmentId = orderShippedEvent.getShipmentId();
        this.orderId = orderShippedEvent.getOrderId();
        this.shipmentStatus = orderShippedEvent.getShipmentStatus();
    }
}
