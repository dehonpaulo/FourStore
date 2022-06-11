package com.foursys.fourstore.dto;

import com.foursys.fourstore.model.Brand;

public class BrandDTO {
    private Long id;
    private String name;
    private String code;

    public BrandDTO() {}

    public BrandDTO(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
        this.code = brand.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
