package com.ecommerce.wProductService.service.imp;

import com.ecommerce.wProductService.entity.ProductType;
import com.ecommerce.wProductService.repository.IProductTypeRepository;
import com.ecommerce.wProductService.service.IProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImp implements IProductTypeService {

    @Autowired
    IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> getProductType() {
        return iProductTypeRepository.findProductTypeByEnable("T");
    }

    @Override
    public void addNewProductType(ProductType productType) {
    	iProductTypeRepository.save(productType);
    }

    @Override
    public void updateProductType(ProductType productType) {
    	ProductType findProductTypeIsExist = iProductTypeRepository.getOne(productType.getId());

        if (findProductTypeIsExist != null) {
        	findProductTypeIsExist.setName(productType.getName());
        	findProductTypeIsExist.setEnable(productType.getEnable());

            iProductTypeRepository.save(findProductTypeIsExist);
        }
    }

}
