package net.muhammadsaad.rest.model;


import lombok.Data;
import net.muhammadsaad.rest.entity.Category;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import java.math.BigDecimal;

@Data
public class ProductModel {

    @NotBlank(message = "Product name is required")
    private String name;

    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be greater than zero")
    private BigDecimal price;

    @URL(message = "Product image URL is invalid")
    private String imageUrl;

    private Boolean isAvailable;

    @Size(max = 1000, message = "Product description must be no more than 1000 characters")
    private String description;

    @NotNull(message = "Product category is required")
    private Category category;
}
