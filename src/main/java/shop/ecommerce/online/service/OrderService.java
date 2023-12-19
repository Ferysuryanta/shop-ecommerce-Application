package shop.ecommerce.online.service;

import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findOrderByCustomer(CustomerDto customerDto);

    OrderDto createOrder(OrderDto orderDto);

    void deleteOrder(Long orderId);
}
