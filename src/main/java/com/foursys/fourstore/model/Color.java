package com.foursys.fourstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "colors")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String value;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String urlImage;
    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL)
    private List<Product> product;

    public Color(){}

    public Color(Long id, String value, String code, String urlImage) {
        this.id = id;
        this.value = value;
        this.code = code;
        this.urlImage = urlImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
