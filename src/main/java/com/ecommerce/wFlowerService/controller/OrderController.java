package com.ecommerce.wFlowerService.controller;

import com.ecommerce.wFlowerService.entity.request.OrderRequest;
import com.ecommerce.wFlowerService.entity.response.BaseResponse;
import com.ecommerce.wFlowerService.security.JwtTokenProvider;
import com.ecommerce.wFlowerService.service.IOrdersService;
import com.ecommerce.wFlowerService.utils.ERRORCODE;
import com.ecommerce.wFlowerService.utils.Utils;
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
