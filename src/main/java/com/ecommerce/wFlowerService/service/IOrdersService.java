package com.ecommerce.wFlowerService.service;

import com.ecommerce.wFlowerService.entity.request.OrderRequest;

public interface IOrdersService {
    void orderProduct(OrderRequest orderRequest);
}
