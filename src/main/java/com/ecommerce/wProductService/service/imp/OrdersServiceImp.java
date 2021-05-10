package com.ecommerce.wProductService.service.imp;

import com.ecommerce.wProductService.entity.OrderDetails;
import com.ecommerce.wProductService.entity.Orders;
import com.ecommerce.wProductService.entity.User;
import com.ecommerce.wProductService.entity.request.OrderRequest;
import com.ecommerce.wProductService.entity.request.ProductRequest;
import com.ecommerce.wProductService.repository.IOrderDetailsRepository;
import com.ecommerce.wProductService.repository.IProductRepository;
import com.ecommerce.wProductService.repository.IUserRepository;
import com.ecommerce.wProductService.service.IOrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersServiceImp implements IOrdersService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IProductRepository iProductRepository;

    @Autowired
    IOrderDetailsRepository iOrderDetailsRepository;

    @Transactional
    @Override
    public void orderProduct(OrderRequest orderRequest) {
        User userOrder = iUserRepository.findUserByUsername(orderRequest.getUsername());
        Orders order = new Orders(orderRequest.getOrdername(), userOrder);

        List<ProductRequest> productRequests = orderRequest.getProducts();
        productRequests.stream().forEach(pr -> {
            iOrderDetailsRepository.save(new OrderDetails(pr.getNumber(), order,
                    iProductRepository.findProductsById(Long.valueOf(pr.getProductID()))
            ));
        });
    }
}
