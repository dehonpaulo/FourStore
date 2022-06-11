package com.foursys.fourstore.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.foursys.fourstore.model.User;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String cpf;
    private String email;
    private List<AddressDTO> adresses;
    private List<SaleResponseDTO> sales;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        if(user.getSales() != null) {
            this.sales = user.getSales().stream().map(sale -> {
                SaleResponseDTO saleResponseDTO = new SaleResponseDTO(sale);
                saleResponseDTO.setUser(null);
                return saleResponseDTO;
            }).toList();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressDTO> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<AddressDTO> adresses) {
        this.adresses = adresses;
    }

    public List<SaleResponseDTO> getSales() {
        return sales;
    }

    public void setSales(List<SaleResponseDTO> sales) {
        this.sales = sales.stream().map(saleResponseDTO -> {
            saleResponseDTO.setUser(null);
            return saleResponseDTO;
        }).toList();
    }
}
