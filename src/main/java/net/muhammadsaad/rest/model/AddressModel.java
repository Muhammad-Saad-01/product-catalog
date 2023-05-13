package net.muhammadsaad.rest.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class AddressModel {
    @NotBlank(message = "Street address is required")
    private String streetAddress;

    @NotBlank(message = "City is required")
    private String city;

    private String state;

    private String postalCode;

    @NotBlank(message = "Country is required")
    private String country;

}
