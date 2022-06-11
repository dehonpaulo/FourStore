package com.foursys.fourstore.model;

import com.foursys.fourstore.enums.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> items;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
    @Column(nullable = false)
    private Double totalPrice;
    @Column(nullable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    public Sale(){};

    public Sale(Long id, List<SaleItem> items, User user, Double totalPrice, LocalDateTime dateTime, PaymentMethod paymentMethod) {
        this.id = id;
        this.items = items;
        this.user = user;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
