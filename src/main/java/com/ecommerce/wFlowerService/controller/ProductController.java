package com.ecommerce.wFlowerService.controller;

import com.ecommerce.wFlowerService.entity.Product;
import com.ecommerce.wFlowerService.entity.response.BaseResponse;
import com.ecommerce.wFlowerService.entity.response.ProductsResponse;
import com.ecommerce.wFlowerService.service.IProductService;
import com.ecommerce.wFlowerService.utils.ERRORCODE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/products")
    private ResponseEntity<BaseResponse> getProducts() {
        List<Product> rs = iProductService.getProducts();
        if (rs != null) {
            return new ResponseEntity<>(new ProductsResponse(rs), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.NORECORD), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    private ResponseEntity<BaseResponse> getProductsByBranchId(@PathVariable(value = "id") long id) {
        List<Product> rs = iProductService.getProductsByBranch(id);
        if (rs != null) {
            return new ResponseEntity<>(new ProductsResponse(rs), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.NORECORD), HttpStatus.OK);
    }

    @GetMapping("/product")
    private ResponseEntity<BaseResponse> getProductById(@RequestParam(name = "id") long id) {
        Product rs = iProductService.getProductById(id);
        if (rs != null) {
            return new ResponseEntity<>(new BaseResponse(rs), HttpStatus.OK);
        }
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.NORECORD), HttpStatus.OK);
    }

    @PostMapping("/product")
    private ResponseEntity<BaseResponse> addNewProduct(@RequestBody Product product) {
        iProductService.addNewProduct(product);
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
    }

    @PutMapping("/product")
    private ResponseEntity<BaseResponse> updateProduct(@RequestBody Product product) {
        iProductService.updateProduct(product);
        return new ResponseEntity<>(new BaseResponse(ERRORCODE.SUCCESS), HttpStatus.OK);
    }

}
