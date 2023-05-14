package net.muhammadsaad.rest.model;


import lombok.Data;
import net.muhammadsaad.rest.entity.Category;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class ProductModel {

    private Long id;

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
    private CategoryModel category;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
}
