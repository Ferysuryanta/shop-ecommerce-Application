package shop.ecommerce.online.service;

import shop.ecommerce.online.dto.OrderDto;
import shop.ecommerce.online.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    List<OrderItemDto> findOrderItemsByOrder(OrderDto orderDto);

    OrderItemDto createOrderItem(OrderItemDto orderItemDto);

    void deleteOrderItem(Long orderItemId);
}
