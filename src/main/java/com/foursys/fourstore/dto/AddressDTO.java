package com.foursys.fourstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.foursys.fourstore.enums.State;
import com.foursys.fourstore.model.Address;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {
    private Long id;
    private State state;
    private String city;
    private String district;
    private String cep;
    private String street;
    private String complement;
    private Integer number;

    public AddressDTO(){}

    public AddressDTO(Long id, State state, String city, String district, String cep, String street, String complement, Integer number) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.district = district;
        this.cep = cep;
        this.street = street;
        this.complement = complement;
        this.number = number;
    }

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.state = address.getState();
        this.city = address.getCity();
        this.district = address.getDistrict();
        this.cep = address.getCep();
        this.street = address.getStreet();
        this.complement = address.getComplement();
        this.number = address.getNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
