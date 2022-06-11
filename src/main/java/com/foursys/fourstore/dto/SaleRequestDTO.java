package com.foursys.fourstore.dto;

import com.foursys.fourstore.enums.PaymentMethod;

import java.util.List;

public class SaleRequestDTO {
    private Long id;
    private List<SaleItemRequestDTO> items;
    private Long userId;
    private PaymentMethod paymentMethod;

    public SaleRequestDTO() {}

    public SaleRequestDTO(Long id, List<SaleItemRequestDTO> items, Long userId, PaymentMethod paymentMethod) {
        this.id = id;
        this.items = items;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<SaleItemRequestDTO> items) {
        this.items = items;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
