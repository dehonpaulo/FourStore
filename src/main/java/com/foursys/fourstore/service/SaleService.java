package com.foursys.fourstore.service;

import com.foursys.fourstore.dto.SaleItemRequestDTO;
import com.foursys.fourstore.dto.SaleRequestDTO;
import com.foursys.fourstore.dto.SaleResponseDTO;
import com.foursys.fourstore.exceptions.EntityNotFoundException;
import com.foursys.fourstore.exceptions.InvalidValueException;
import com.foursys.fourstore.exceptions.UnreportedEssentialFieldException;
import com.foursys.fourstore.model.Product;
import com.foursys.fourstore.model.Sale;
import com.foursys.fourstore.model.SaleItem;
import com.foursys.fourstore.model.User;
import com.foursys.fourstore.repository.ProductRepository;
import com.foursys.fourstore.repository.SaleItemRepository;
import com.foursys.fourstore.repository.SaleRepository;
import com.foursys.fourstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SaleItemRepository saleItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<SaleResponseDTO> findAll() {
        return saleRepository.findAll().stream().map(sale -> new SaleResponseDTO(sale)).toList();
    }

    public SaleResponseDTO findById(Long id) {
        return new SaleResponseDTO(saleRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe uma venda com o id informado");
        }));
    }

    public List<SaleResponseDTO> findByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
           return new EntityNotFoundException("Não existe um usuário com o id informado");
        });

        return saleRepository.findByUser(user).stream().map(sale -> {
            return new SaleResponseDTO(sale);
        }).toList();
    }

    public SaleResponseDTO save(SaleRequestDTO saleRequestDTO) {
        Sale sale = new Sale();

        if(saleRequestDTO.getUserId() == null) throw new UnreportedEssentialFieldException("Usuário não informado");
        sale.setUser(userRepository.findById(saleRequestDTO.getUserId()).orElseThrow(() -> {
            return new EntityNotFoundException("Não existe um usuário com o id informado");
        }));

        if(saleRequestDTO.getItems() == null) throw new UnreportedEssentialFieldException("Produtos não informados");
        List<SaleItem> items = new ArrayList<>();
        Double totalPrice = 0.0;
        for(SaleItemRequestDTO saleItemRequestDTO : saleRequestDTO.getItems()) {
            Product product = productRepository.findById(saleItemRequestDTO.getProductId()).orElseThrow(() -> {
                return new EntityNotFoundException("Não existe um produto com o id informado");
            });

            if(saleItemRequestDTO.getQuantity() > product.getQuantity()) throw new InvalidValueException("Quantidade superior à disponível em estoque");

            totalPrice += product.getSalePrice() * saleItemRequestDTO.getQuantity();
            items.add(new SaleItem(product, saleItemRequestDTO.getQuantity()));
        }
        sale.setItems(items);
        sale.setTotalPrice(totalPrice);

        if(saleRequestDTO.getPaymentMethod() == null) throw new UnreportedEssentialFieldException("Método de pagamento não informado");
        sale.setPaymentMethod(saleRequestDTO.getPaymentMethod());

        sale.setDateTime(LocalDateTime.now());

        Sale savedSale = saleRepository.save(sale);

        for(SaleItem item : sale.getItems()) {
            item.setSale(savedSale);
            saleItemRepository.save(item);
        }

        return new SaleResponseDTO(saleRepository.findById(savedSale.getId()).get());
    }

    public void deleteById(Long id) {
        this.findById(id);
        saleRepository.deleteById(id);
    }
}
