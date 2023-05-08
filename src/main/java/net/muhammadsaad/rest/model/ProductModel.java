package net.muhammadsaad.rest.model;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private String imageUrl;
    private Boolean isAvailable;
    private String description;
}
