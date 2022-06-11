package com.foursys.fourstore.model;

import com.foursys.fourstore.enums.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private Brand brand;
    private String description;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "model_code", nullable = false)
    private String modelCode;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Size size;
    @Enumerated(EnumType.STRING)
    private Fit fit;
    private String sku;
    @Column(name = "purchase_price", nullable = false)
    private Double purchasePrice;
    @Column(name = "sale_price", nullable = false)
    private Double salePrice;
    @Column(nullable = false)
    private Integer quantity;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;

    public Product(){};

    public Product(Brand brand, String description, Type type, Category category, String modelCode, Color color,
                   Sex sex, Size size, Fit fit, Double purchasePrice, Double salePrice, Integer quantity) {
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
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
