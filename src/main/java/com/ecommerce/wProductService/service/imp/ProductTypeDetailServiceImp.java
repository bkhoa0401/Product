package com.ecommerce.wProductService.service.imp;

import com.ecommerce.wProductService.entity.ProductType;
import com.ecommerce.wProductService.entity.ProductTypeDetail;
import com.ecommerce.wProductService.repository.IProductTypeDetailRepository;
import com.ecommerce.wProductService.repository.IProductTypeRepository;
import com.ecommerce.wProductService.service.IProductTypeDetailService;
import com.ecommerce.wProductService.service.IProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeDetailServiceImp implements IProductTypeDetailService {

    @Autowired
    IProductTypeDetailRepository iProductTypeDetailRepository;

	@Override
	public List<ProductTypeDetail> getProductTypeDetail() {
		return iProductTypeDetailRepository.findProductTypeDetailByEnable("T");
	}

	@Override
	public void addNewProductTypeDetail(ProductTypeDetail productTypeDetail) {
		iProductTypeDetailRepository.save(productTypeDetail);
	}

	@Override
	public void updateProductTypeDetail(ProductTypeDetail productTypeDetail) {
		ProductTypeDetail findProductTypeDetailIsExist = iProductTypeDetailRepository.getOne(productTypeDetail.getId());

        if (findProductTypeDetailIsExist != null) {
        	findProductTypeDetailIsExist.setName(productTypeDetail.getName());
        	findProductTypeDetailIsExist.setEnable(productTypeDetail.getEnable());

        	iProductTypeDetailRepository.save(findProductTypeDetailIsExist);
        }
		
	}

}
