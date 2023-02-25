package com.mahi.javapassion.shipmentservice.commoand.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHIPMENTS")
public class ShipmentEntity {
    @Id
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;
    private LocalDate shipmentDate;
}
