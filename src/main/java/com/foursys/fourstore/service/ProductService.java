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

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;

    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Product product = new Product();

        if(productRequestDTO.getIdBrand() == null) throw new UnreportedEssentialFieldException("Marca não informada");
        product.setBrand(brandRepository.findById(productRequestDTO.getIdBrand()).orElseThrow(() -> {
            return new EntityNotFoundException("A marca informada não existe no banco de dados");
        }));

        if(productRequestDTO.getDescription() != null) product.setDescription(productRequestDTO.getDescription());

        if(productRequestDTO.getType() != null) product.setType(productRequestDTO.getType());

        if(productRequestDTO.getCategory() != null) product.setCategory(productRequestDTO.getCategory());

        String modelCode = String.valueOf(productRepository.countProductsByBrand(product.getBrand()) + 1);
        modelCode = "0".repeat(6 - modelCode.length()) + modelCode;
        product.setModelCode(modelCode);
        
        if(productRequestDTO.getColor() == null) throw new UnreportedEssentialFieldException("Cor não informada");
        product.setColor(productRequestDTO.getColor());

        if(productRequestDTO.getSex() != null) product.setSex(productRequestDTO.getSex());

        if(productRequestDTO.getSize() == null) throw new UnreportedEssentialFieldException("Tamanho não informado");
        product.setSize(productRequestDTO.getSize());

        if(productRequestDTO.getFit() != null) product.setFit(productRequestDTO.getFit());

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
                + product.getColor().getColorNumber()
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

    //--------------------------------------------------------------------------------

    public ProductResponseDTO findBySku(String sku) {
        Product product = productRepository.findBySku(sku);
        if(product == null) throw new EntityNotFoundException("Não existe um produto com o sku informado");
        return new ProductResponseDTO(product);
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
            return new EntityNotFoundException("A marca informada não existe no banco de dados");
        }));

        if(productRequestDTO.getDescription() != null) product.setDescription(productRequestDTO.getDescription());

        if(productRequestDTO.getType() != null) product.setType(productRequestDTO.getType());

        if(productRequestDTO.getCategory() != null) product.setCategory(productRequestDTO.getCategory());

        if(productRequestDTO.getColor() != null) product.setColor(productRequestDTO.getColor());

        if(productRequestDTO.getSex() != null) product.setSex(productRequestDTO.getSex());

        if(productRequestDTO.getSize() != null) product.setSize(productRequestDTO.getSize());

        if(productRequestDTO.getFit() != null) product.setFit(productRequestDTO.getFit());

        if(productRequestDTO.getPurchasePrice() != null) {
            if(productRequestDTO.getPurchasePrice() < 0) throw new InvalidValueException("Preço de compra inválido");
            product.setPurchasePrice(productRequestDTO.getPurchasePrice());
        }

        if(productRequestDTO.getSalePrice() != null) {
            if(productRequestDTO.getSalePrice() < 0) throw new InvalidValueException("Preço de venda inválido");
            product.setSalePrice(productRequestDTO.getSalePrice());
        }

        if(productRequestDTO.getQuantity() != null) {
            if(productRequestDTO.getQuantity() < 0) throw new InvalidValueException("Quantidade inválida");
            product.setQuantity(productRequestDTO.getQuantity());
        }

        product.setSku(product.getBrand().getCode()
                + product.getModelCode()
                + product.getColor().getColorNumber()
                + product.getSize().toString());

        return new ProductResponseDTO(productRepository.save(product));
    }

    public Integer supplyProductStockById(Long id, Integer quantity) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um produto com o id informado");
        });

        if(quantity < 0) throw new InvalidValueException("Quantidade inválida");

        Integer newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);
        productRepository.save(product);
        return newQuantity;
    }

    public Integer supplyProductStockBySku(String sku, Integer quantity) {
        Product product = productRepository.findBySku(sku);
        if(product == null) throw new EntityNotFoundException("Não existe um produto com o sku informado");
        if(quantity < 0) throw new InvalidValueException("Quantidade inválida");

        Integer newQuantity = product.getQuantity() + quantity;
        product.setQuantity(newQuantity);
        productRepository.save(product);
        return newQuantity;
    }
}