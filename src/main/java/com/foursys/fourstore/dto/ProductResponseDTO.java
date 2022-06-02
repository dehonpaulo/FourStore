package com.foursys.fourstore.dto;

import com.foursys.fourstore.model.Product;

public class ProductResponseDTO {
    private Long id;
    private String brand;
    private String description;
    private String type;
    private String category;
    private String modelCode;
    private String color;
    private String sex;
    private String size;
    private String fit;
    private Double purchasePrice;
    private Double salePrice;
    private Integer quantity;
    private String sku;

    public ProductResponseDTO(){};

    public ProductResponseDTO(Long id, String brand, String description, String type, String category, String modelCode, String color, String sex, String size, String fit, Double purchasePrice, Double salePrice, Integer quantity, String sku) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.type = type;
        this.category = category;
        this.modelCode = modelCode;
        this.color = color;
        this.sex = sex;
        this.size = size;
        this.fit = fit;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.sku = sku;
    }

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.brand = product.getBrand().getName();
        this.description = product.getDescription();
        this.type = product.getType().getValue();
        this.category = product.getCategory().getValue();
        this.modelCode = product.getModelCode();
        this.color = product.getColor().getValue();
        this.sex = product.getSex().toString();
        this.size = product.getSize().toString();
        this.fit = product.getFit().getValue();
        this.purchasePrice = product.getPurchasePrice();
        this.salePrice = product.getSalePrice();
        this.quantity = product.getQuantity();
        this.sku = product.getSku();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
