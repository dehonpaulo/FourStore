package com.foursys.fourstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.foursys.fourstore.enums.*;
import com.foursys.fourstore.model.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequestDTO {
    private Long id;
    private Long idBrand;
    private String description;
    private Type type;
    private Category category;
    private String modelCode;
    private Color color;
    private Sex sex;
    private Size size;
    private Fit fit;
    private Double purchasePrice;
    private Double salePrice;
    private Integer quantity;

    public ProductRequestDTO() {}

    public ProductRequestDTO(Product product) {
        this.id = product.getId();
        this.idBrand = product.getBrand().getId();
        this.description = product.getDescription();
        this.type = product.getType();
        this.category = product.getCategory();
        this.modelCode = product.getModelCode();
        this.color = product.getColor();
        this.sex = product.getSex();
        this.size = product.getSize();
        this.fit = product.getFit();
        this.purchasePrice = product.getPurchasePrice();
        this.salePrice = product.getSalePrice();
        this.quantity = product.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Long idBrand) {
        this.idBrand = idBrand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Fit getFit() {
        return fit;
    }

    public void setFit(Fit fit) {
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
}