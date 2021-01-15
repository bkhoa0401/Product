package com.ecommerce.wFlowerService.service.imp;

import com.ecommerce.wFlowerService.entity.OrderDetails;
import com.ecommerce.wFlowerService.entity.Orders;
import com.ecommerce.wFlowerService.entity.User;
import com.ecommerce.wFlowerService.entity.request.OrderRequest;
import com.ecommerce.wFlowerService.entity.request.ProductRequest;
import com.ecommerce.wFlowerService.repository.IOrderDetailsRepository;
import com.ecommerce.wFlowerService.repository.IProductRepository;
import com.ecommerce.wFlowerService.repository.IUserRepository;
import com.ecommerce.wFlowerService.service.IOrdersService;
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
