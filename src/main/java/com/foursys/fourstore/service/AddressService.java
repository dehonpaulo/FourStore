package com.foursys.fourstore.service;

import com.foursys.fourstore.dto.AddressDTO;
import com.foursys.fourstore.exceptions.EntityNotFoundException;
import com.foursys.fourstore.exceptions.UnreportedEssentialFieldException;
import com.foursys.fourstore.model.Address;
import com.foursys.fourstore.model.User;
import com.foursys.fourstore.repository.AddressRepository;
import com.foursys.fourstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    public List<AddressDTO> findAll() {
        return addressRepository.findAll().stream().map(address -> new AddressDTO(address)).toList();
    }


    public AddressDTO findById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um endereço com o id informado");
        });

        return new AddressDTO(address);
    }


    public List<AddressDTO> findByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um usuário com o id informado");
        });

        return addressRepository.findByUser(user).stream().map(address -> new AddressDTO(address)).toList();
    }


    public AddressDTO save(Long userId, AddressDTO addressDTO) {
        Address address = new Address();

        address.setUser(userRepository.findById(userId).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um usuário com o id informado");
        }));

        if(addressDTO.getState() == null) throw new UnreportedEssentialFieldException("Estado não informado");
        address.setState(addressDTO.getState());

        if(addressDTO.getCity() == null) throw new UnreportedEssentialFieldException("Cidade não informada");
        address.setCity(addressDTO.getCity());

        if(addressDTO.getDistrict() == null) throw new UnreportedEssentialFieldException("Bairro não informado");
        address.setDistrict(addressDTO.getDistrict());

        if(addressDTO.getCep() == null) throw new UnreportedEssentialFieldException("Cep não informado");
        address.setCep(addressDTO.getCep());

        if(addressDTO.getStreet() == null) throw new UnreportedEssentialFieldException("Rua não informada");
        address.setStreet(addressDTO.getStreet());

        if(addressDTO.getNumber() == null) throw new UnreportedEssentialFieldException("Número não informado");
        address.setNumber(addressDTO.getNumber());

        if(addressDTO.getComplement() != null) address.setComplement(addressDTO.getComplement());

        return new AddressDTO(addressRepository.save(address));
    }


    public AddressDTO update(Long id, AddressDTO addressDTO) {
        Address address = addressRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um endereço com o id informado");
        });

        if(address.getState() != null) address.setState(addressDTO.getState());
        if(address.getCity() != null) address.setCity(addressDTO.getCity());
        if(address.getDistrict() != null) address.setDistrict(addressDTO.getDistrict());
        if(address.getCep() != null) address.setCep(addressDTO.getCep());
        if(address.getStreet() != null) address.setStreet(addressDTO.getStreet());
        if(address.getNumber() != null) address.setNumber(addressDTO.getNumber());
        if(address.getComplement() != null) address.setComplement(addressDTO.getComplement());

        return new AddressDTO(addressRepository.save(address));
    }


    public void delete(Long id) {
        this.findById(id);
        addressRepository.deleteById(id);
    }
}