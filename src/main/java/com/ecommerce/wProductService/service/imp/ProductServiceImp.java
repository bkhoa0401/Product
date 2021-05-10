package com.ecommerce.wProductService.service.imp;

import com.ecommerce.wProductService.entity.Product;
import com.ecommerce.wProductService.repository.IProductRepository;
import com.ecommerce.wProductService.service.IProductService;

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
        return iProductRepository.findProducts();
    }

    @Override
    public List<Product> getProductsByBranch(long id) {
        return iProductRepository.findProductsByBranchID(id);
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

    @Override
    public void updateProduct(Product product) {
        Product productIsExist = iProductRepository.getOne(product.getId());

        if (productIsExist != null) {
            if (product.getImagesDetail() != null && !"".equals(product.getImagesDetail())) {
                productIsExist.setImagesDetail(product.getImagesDetail());
            }
            if (product.getImage() != null && !"".equals(product.getImage())) {
                productIsExist.setImage(product.getImage());
            }
            if (product.getEnable() != null && !"".equals(product.getEnable())) {
                productIsExist.setEnable(product.getEnable());
            }
            if (product.getName() != null && !"".equals(product.getName())) {
                productIsExist.setName(product.getName());
            }
            if (product.getNewPrice() != null && !"".equals(product.getNewPrice())) {
                productIsExist.setNewPrice(product.getNewPrice());
            }
            if (product.getOldPrice() != null && !"".equals(product.getOldPrice())) {
                productIsExist.setOldPrice(product.getOldPrice());
            }

            iProductRepository.save(productIsExist);
        }
    }
}
