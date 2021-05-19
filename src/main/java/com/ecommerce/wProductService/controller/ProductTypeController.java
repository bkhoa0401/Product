package com.ecommerce.wProductService.controller;

import com.ecommerce.wProductService.entity.ProductType;
import com.ecommerce.wProductService.entity.response.BaseResponse;
import com.ecommerce.wProductService.service.IProductTypeService;
import com.ecommerce.wProductService.utils.ERRORCODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductTypeController {

    @Autowired
    IProductTypeService iProductTypeService;

    @GetMapping("/producttype")
    private ResponseEntity<BaseResponse<List<ProductType>>>  getProductType() {
        return new ResponseEntity<>(new BaseResponse<>(iProductTypeService.getProductType()),HttpStatus.OK);
    }

    @PostMapping("/producttype")
    private ResponseEntity<BaseResponse> addNewProductType(@RequestBody ProductType productType) {

        if (productType.getName() != null && !"".equals(productType.getName())) {
            iProductTypeService.addNewProductType(productType);
            return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.BADREQUEST), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/producttype")
    private ResponseEntity<BaseResponse> updateProductType(@RequestBody ProductType productType) {
        if (productType.getName() != null && !"".equals(productType.getName())) {
        	iProductTypeService.updateProductType(productType);
            return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.BADREQUEST), HttpStatus.BAD_REQUEST);
    }

}
