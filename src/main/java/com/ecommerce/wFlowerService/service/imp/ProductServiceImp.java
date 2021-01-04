package com.ecommerce.wFlowerService.service.imp;

import com.ecommerce.wFlowerService.entity.Product;
import com.ecommerce.wFlowerService.repository.IProductRepository;
import com.ecommerce.wFlowerService.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements IProductService {

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> getProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> rs = iProductRepository.findById(id);
        if (rs.isPresent()) {
            return rs.get();
        }
        return null;
    }

    @Override
    public void addNewProduct(Product product) {
        iProductRepository.save(product);
    }
}
