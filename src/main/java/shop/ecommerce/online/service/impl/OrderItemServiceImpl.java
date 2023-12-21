package shop.ecommerce.online.service.impl;

import org.springframework.stereotype.Service;
import shop.ecommerce.online.dto.OrderDto;
import shop.ecommerce.online.dto.OrderItemDto;
import shop.ecommerce.online.mapper.OrderItemMapper;
import shop.ecommerce.online.mapper.OrderMapper;
import shop.ecommerce.online.model.Order;
import shop.ecommerce.online.model.OrderItem;
import shop.ecommerce.online.repository.OrderItemRepository;
import shop.ecommerce.online.service.OrderItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository repository;
    @Override
    public List<OrderItemDto> findOrderItemsByOrder(OrderDto orderDto) {
        Order order = OrderMapper.toEntity(orderDto);
        List<OrderItem> orderItems = repository.findByOrder(order);
        return orderItems.stream().map(OrderItemMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = OrderItemMapper.toEntity(orderItemDto);
        OrderItem saveOrderItem = repository.save(orderItem);
        return OrderItemMapper.toDto(saveOrderItem);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        repository.deleteById(orderItemId);
    }
}
