package com.foursys.fourstore.service;

import com.foursys.fourstore.dto.ProductRequestDTO;
import com.foursys.fourstore.dto.ProductResponseDTO;
import com.foursys.fourstore.enums.Sex;
import com.foursys.fourstore.enums.Size;
import com.foursys.fourstore.exceptions.EntityNotFoundException;
import com.foursys.fourstore.exceptions.InvalidValueException;
import com.foursys.fourstore.exceptions.UnreportedEssentialFieldException;
import com.foursys.fourstore.model.Product;
import com.foursys.fourstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private FitRepository fitRepository;

    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        if(productRequestDTO.getIdBrand() == null) throw new UnreportedEssentialFieldException("Marca não informada");
        product.setBrand(brandRepository.findById(productRequestDTO.getIdBrand()).orElseThrow(() -> {
            return new EntityNotFoundException("A marca informada não existe no banco de dados");
        }));

        if(productRequestDTO.getDescription() != null) product.setDescription(productRequestDTO.getDescription());

        if(productRequestDTO.getIdType() != null) {
            product.setType(typeRepository.findById(productRequestDTO.getIdType()).orElseThrow(() -> {
                return new EntityNotFoundException("O tipo informado não existe no banco de dados");
            }));
        }

        if(productRequestDTO.getIdCategory() != null) {
            product.setCategory(categoryRepository.findById(productRequestDTO.getIdCategory()).orElseThrow(() -> {
                return new EntityNotFoundException("A categoria informada não existe no banco de dados");
            }));
        }

        String modelCode = String.valueOf(productRepository.countProductsByBrand(product.getBrand()) + 1);
        modelCode = "0".repeat(6 - modelCode.length()) + modelCode;
        product.setModelCode(modelCode);
        
        if(productRequestDTO.getIdColor() == null) throw new UnreportedEssentialFieldException("Cor não informada");
        product.setColor(colorRepository.findById(productRequestDTO.getIdColor()).orElseThrow(() -> {
            return new EntityNotFoundException("A cor informada não existe no banco de dados");
        }));

        if(productRequestDTO.getSex() != null) {
            Sex sex = Sex.getFromString(productRequestDTO.getSex());
            if(sex == null) throw new InvalidValueException("Sexo inválido");
            product.setSex(sex);
        }

        if(productRequestDTO.getSize() != null) {
            Size size = Size.getFromString(productRequestDTO.getSize());
            if(size == null) throw new InvalidValueException("Sexo inválido");
            product.setSize(size);
        }

        if(productRequestDTO.getIdFit() != null) {
            product.setFit(fitRepository.findById(productRequestDTO.getIdFit()).orElseThrow(() -> {
                return new EntityNotFoundException("O fit informado não existe no banco de dados");
            }));
        }

        if(productRequestDTO.getPurchasePrice() == null) throw new UnreportedEssentialFieldException("Preço de compra não informado");
        if(productRequestDTO.getPurchasePrice() < 0) throw new InvalidValueException("Preço de compra inválido");
        product.setPurchasePrice(productRequestDTO.getPurchasePrice());

        if(productRequestDTO.getSalePrice() == null) throw new UnreportedEssentialFieldException("Preço de venda não informado");
        if(productRequestDTO.getSalePrice() < 0) throw new InvalidValueException("Preço de venda inválido");
        product.setSalePrice(productRequestDTO.getSalePrice());

        if(productRequestDTO.getQuantity() == null) throw new UnreportedEssentialFieldException("Quantidade não informada");
        if(productRequestDTO.getQuantity() < 0) throw new InvalidValueException("Quantidade inválida");
        product.setQuantity(productRequestDTO.getQuantity());

        product.setSku(product.getBrand().getCode()
                + product.getModelCode()
                + product.getColor().getCode()
                + product.getSize().toString());

        return new ProductResponseDTO(productRepository.save(product));
    }

    //---------------------------------------------------------------------------------

    public ProductResponseDTO findBydId(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
          return new EntityNotFoundException("Não existe um produto com o id informado");
        });
        return new ProductResponseDTO(product);
    }

    //---------------------------------------------------------------------------------

    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll().stream().map(product -> {
            return new ProductResponseDTO(product);
        }).toList();
    }

    //---------------------------------------------------------------------------------

    public void deleteById(Long id) {
        this.findBydId(id);
        productRepository.deleteById(id);
    }

    //---------------------------------------------------------------------------------

    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um produto com o id informado");
        });

        if(productRequestDTO.getIdBrand() != null) product.setBrand(brandRepository.findById(productRequestDTO.getIdBrand()).orElseThrow(() -> {
            return new EntityNotFoundException("");
        }));
    }
}