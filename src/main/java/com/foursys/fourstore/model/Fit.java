package com.foursys.fourstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fits")
public class Fit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fit", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String value;
    @OneToMany(mappedBy = "fit", cascade = CascadeType.ALL)
    private List<Product> products;

    public Fit(){}

    public Fit(Long id, String value) {
        this.id = id;
        this.value = value;
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
}
