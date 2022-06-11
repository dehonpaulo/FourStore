package com.foursys.fourstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.foursys.fourstore.model.SaleItem;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleItemResponseDTO {
    private Long id;
    private ProductResponseDTO product;
    private Integer quantity;

    public SaleItemResponseDTO() {}

    public SaleItemResponseDTO(Long id, ProductResponseDTO product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public SaleItemResponseDTO(SaleItem saleItem) {
        this.id = saleItem.getId();
        this.product = new ProductResponseDTO(saleItem.getProduct());
        this.quantity = saleItem.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductResponseDTO getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDTO product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
