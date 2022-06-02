package com.foursys.fourstore.model;

import javax.persistence.*;

@Entity
@Table(name = "sale_items")
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale_item", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "id_sale")
    private Sale sale;

    public SaleItem(){};

    public SaleItem(Long id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
