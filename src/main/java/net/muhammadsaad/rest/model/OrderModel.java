package net.muhammadsaad.rest.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class OrderModel {
    @NotNull(message = "Customer ID is required")
    private Long customerId;

    private LocalDateTime orderDate;

    private LocalDateTime shipDate;

    @NotBlank(message = "Status is required")
    private String status;
}
