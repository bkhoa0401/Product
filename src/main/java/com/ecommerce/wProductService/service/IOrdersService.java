package com.ecommerce.wProductService.service;

import com.ecommerce.wProductService.entity.request.OrderRequest;

public interface IOrdersService {
    void orderProduct(OrderRequest orderRequest);
}
