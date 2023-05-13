package net.muhammadsaad.rest.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryModel {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;
}
