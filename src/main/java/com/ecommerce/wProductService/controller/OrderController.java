package com.ecommerce.wProductService.controller;

import com.ecommerce.wProductService.entity.request.OrderRequest;
import com.ecommerce.wProductService.entity.response.BaseResponse;
import com.ecommerce.wProductService.security.JwtTokenProvider;
import com.ecommerce.wProductService.service.IOrdersService;
import com.ecommerce.wProductService.utils.ERRORCODE;
import com.ecommerce.wProductService.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    IOrdersService iOrdersService;

    @PostMapping("/order")
    private ResponseEntity<BaseResponse> orderProduct(HttpServletRequest request,
                                                      @RequestBody OrderRequest orderRequest) {
        if (Utils.checkUserNameFTokenAndUserNameFromBIsMatched(request, orderRequest.getUsername())) {
            iOrdersService.orderProduct(orderRequest);
            return new ResponseEntity(new BaseResponse(), HttpStatus.OK);
        }
        return new ResponseEntity(new BaseResponse(ERRORCODE.TOKENNOTVALID), HttpStatus.UNAUTHORIZED);
    }

}
