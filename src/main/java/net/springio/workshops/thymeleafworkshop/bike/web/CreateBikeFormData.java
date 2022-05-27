package net.springio.workshops.thymeleafworkshop.bike.web;

import net.springio.workshops.thymeleafworkshop.bike.CreateBikeParameters;

import javax.validation.constraints.NotBlank;

public class CreateBikeFormData {
    @NotBlank
    private String brand;
    @NotBlank
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CreateBikeParameters toParameters() {
        return new CreateBikeParameters(brand, type);
    }
}
