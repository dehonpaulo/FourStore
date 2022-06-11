package com.foursys.fourstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.foursys.fourstore.enums.PaymentMethod;
import com.foursys.fourstore.model.Sale;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleResponseDTO {
    private Long id;
    private List<SaleItemResponseDTO> items;
    private UserResponseDTO user;
    private Double totalPrice;
    private String dateTime;
    private PaymentMethod paymentMethod;

    public SaleResponseDTO(){}

    public SaleResponseDTO(Sale sale) {
        this.id = sale.getId();
        this.items = sale.getItems().stream().map(item -> new SaleItemResponseDTO(item)).toList();
        this.user = new UserResponseDTO(sale.getUser());
        this.user.setSales(null);
        this.totalPrice = sale.getTotalPrice();
        this.dateTime = sale.getDateTime().getYear()
                + "-" + sale.getDateTime().getMonthValue()
                + "-" + sale.getDateTime().getDayOfMonth()
                + " " + sale.getDateTime().getHour()
                + ":" + sale.getDateTime().getMinute();
        this.paymentMethod = sale.getPaymentMethod();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItemResponseDTO> getItems() {
        return items;
    }

    public void setItems(List<SaleItemResponseDTO> items) {
        this.items = items;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        user.setSales(null);
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime.getYear()
                + "-" + dateTime.getMonthValue()
                + "-" + dateTime.getDayOfMonth()
                + " " + dateTime.getHour()
                + ":" + dateTime.getMinute();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}