package com.foursys.fourstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.foursys.fourstore.model.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRequestDTO {
    private Long id;
    private Long idBrand;
    private String description;
    private Long idType;
    private Long idCategory;
    private String modelCode;
    private Long idColor;
    private String sex;
    private String size;
    private Long idFit;
    private Double purchasePrice;
    private Double salePrice;
    private Integer quantity;

    public ProductRequestDTO() {}

    public ProductRequestDTO(Long id, Long idBrand, String description, Long idType, Long idCategory, String modelCode, Long idColor, String sex, String size, Long idFit, Double purchasePrice, Double salePrice, Integer quantity) {
        this.id = id;
        this.idBrand = idBrand;
        this.description = description;
        this.idType = idType;
        this.idCategory = idCategory;
        this.modelCode = modelCode;
        this.idColor = idColor;
        this.sex = sex;
        this.size = size;
        this.idFit = idFit;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.quantity = quantity;
    }

    public ProductRequestDTO(Product product) {
        this.id = product.getId();
        this.idBrand = product.getBrand().getId();
        this.description = product.getDescription();
        this.idType = product.getType().getId();
        this.idCategory = product.getCategory().getId();
        this.modelCode = product.getModelCode();
        this.idColor = product.getColor().getId();
        this.sex = product.getSex().toString();
        this.size = product.getSize().toString();
        this.idFit = product.getFit().getId();
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

    public Long getIdType() {
        return idType;
    }

    public void setIdType(Long idType) {
        this.idType = idType;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Long getIdColor() {
        return idColor;
    }

    public void setIdColor(Long idColor) {
        this.idColor = idColor;
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

    public Long getIdFit() {
        return idFit;
    }

    public void setIdFit(Long idFit) {
        this.idFit = idFit;
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