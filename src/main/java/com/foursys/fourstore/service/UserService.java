package com.foursys.fourstore.service;

import com.foursys.fourstore.dto.UserRequestDTO;
import com.foursys.fourstore.dto.UserResponseDTO;
import com.foursys.fourstore.exceptions.EntityNotFoundException;
import com.foursys.fourstore.exceptions.UnreportedEssentialFieldException;
import com.foursys.fourstore.model.User;
import com.foursys.fourstore.repository.AddressRepository;
import com.foursys.fourstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    public UserResponseDTO findById(Long id) {
        return new UserResponseDTO(userRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um usuário com o id informado");
        }));
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll().stream().map(user -> new UserResponseDTO(user)).toList();
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        User user = new User();

        if(userRequestDTO.getFullName() == null) throw new UnreportedEssentialFieldException("Nome completo não informado");
        user.setFullName(userRequestDTO.getFullName());

        if(userRequestDTO.getEmail() == null) throw new UnreportedEssentialFieldException("Email não informado");
        user.setEmail(userRequestDTO.getEmail());

        if(userRequestDTO.getCpf() == null) throw new UnreportedEssentialFieldException("CPF não informado");
        user.setCpf(userRequestDTO.getCpf());

        if(userRequestDTO.getPassword() == null) throw new UnreportedEssentialFieldException("Senha não informada");
        user.setPassword(userRequestDTO.getPassword());

        return new UserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um usuário com o id informado");
        });

        if(userRequestDTO.getFullName() != null) user.setFullName(userRequestDTO.getFullName());

        if(userRequestDTO.getEmail() != null) user.setEmail(userRequestDTO.getEmail());

        if(userRequestDTO.getCpf() != null) user.setCpf(userRequestDTO.getCpf());

        if(userRequestDTO.getPassword() != null) user.setPassword(userRequestDTO.getPassword());

        return new UserResponseDTO(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um usuário com o id informado");
        }));
    }
}