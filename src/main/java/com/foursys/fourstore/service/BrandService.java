package com.foursys.fourstore.service;

import com.foursys.fourstore.dto.BrandDTO;
import com.foursys.fourstore.exceptions.EntityNotFoundException;
import com.foursys.fourstore.exceptions.UnreportedEssentialFieldException;
import com.foursys.fourstore.model.Brand;
import com.foursys.fourstore.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<BrandDTO> findAll() {
        return brandRepository.findAll().stream().map(brand -> {
            return new BrandDTO(brand);
        }).toList();
    }

    public BrandDTO findById(Long id) {
        return new BrandDTO(brandRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe uma marca com o id informado");
        }));
    }

    public BrandDTO save(BrandDTO brandDTO) {
        Brand brand = new Brand();

        if(brandDTO.getName() == null || brandDTO.getName() == "") throw new UnreportedEssentialFieldException("Nome da marca não informado");
        brand.setName(brandDTO.getName());

        if(brandDTO.getCode() == null || brandDTO.getCode() == "") throw new UnreportedEssentialFieldException("Código da marca não informado");
        brand.setCode(brandDTO.getCode());

        return new BrandDTO(brandRepository.save(brand));
    }

    public void deleteById(Long id) {
        this.findById(id);
        brandRepository.deleteById(id);
    }
}
