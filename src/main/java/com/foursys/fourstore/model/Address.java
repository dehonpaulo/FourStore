package com.foursys.fourstore.model;

import com.foursys.fourstore.enums.State;

import javax.persistence.*;

@Entity
@Table(name = "adresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", nullable = false)
    private Long id;
    private State state;
}
