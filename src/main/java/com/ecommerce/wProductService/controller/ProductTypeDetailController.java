package com.ecommerce.wProductService.controller;

import com.ecommerce.wProductService.entity.ProductTypeDetail;
import com.ecommerce.wProductService.entity.response.BaseResponse;
import com.ecommerce.wProductService.service.IProductTypeDetailService;
import com.ecommerce.wProductService.utils.ERRORCODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductTypeDetailController {

    @Autowired
    IProductTypeDetailService iProductTypeServiceDetail;

    @GetMapping("/producttypedetail")
    private ResponseEntity<BaseResponse<List<ProductTypeDetail>>>  getProductTypeDetail() {
        return new ResponseEntity<>(new BaseResponse<>(iProductTypeServiceDetail.getProductTypeDetail()),HttpStatus.OK);
    }
    
    @GetMapping("/producttypedetail/{id}")
    private ResponseEntity<BaseResponse<List<ProductTypeDetail>>> getProductTypeDetailByProductTypeID(@PathVariable long id) {
    	return new ResponseEntity<>(new BaseResponse<>(iProductTypeServiceDetail.getProductTypeDetailByProductTypeID(id))
    			,HttpStatus.OK);
    }

    @PostMapping("/producttypedetail")
    private ResponseEntity<BaseResponse> addNewProductTypeDetail(@RequestBody ProductTypeDetail productTypeDetail) {

        if (productTypeDetail.getName() != null && !"".equals(productTypeDetail.getName())) {
            iProductTypeServiceDetail.addNewProductTypeDetail(productTypeDetail);
            return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.BADREQUEST), HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/producttypedetail")
    private ResponseEntity<BaseResponse> updateProductType(@RequestBody ProductTypeDetail productTypeDetail) {
        if (productTypeDetail.getName() != null && !"".equals(productTypeDetail.getName())) {
        	iProductTypeServiceDetail.updateProductTypeDetail(productTypeDetail);
            return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.BADREQUEST), HttpStatus.BAD_REQUEST);
    }

}
