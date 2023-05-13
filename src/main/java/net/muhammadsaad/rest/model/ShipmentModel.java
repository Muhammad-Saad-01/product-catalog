package net.muhammadsaad.rest.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ShipmentModel {
    @NotNull(message = "Order ID is required")
    private Long orderId;

    private LocalDateTime shipDate;

    private LocalDateTime deliveryDate;

    @NotNull(message = "Status ID is required")
    private Long statusId;
}
