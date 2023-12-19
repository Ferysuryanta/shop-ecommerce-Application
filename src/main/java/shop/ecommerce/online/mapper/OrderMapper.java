package shop.ecommerce.online.mapper;

import shop.ecommerce.online.dto.OrderDto;
import shop.ecommerce.online.dto.OrderItemDto;
import shop.ecommerce.online.model.Order;
import shop.ecommerce.online.model.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDto toDto(Order order) {
        List<OrderItemDto> orderItems = order.getOrderItems().stream()
                .map(OrderItemMapper::toDto)
                .toList();

        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCustomer(CustomerMapper.toDto(order.getCustomer()));
        orderDto.setBillingAddress(AddressMapper.toDto(order.getBillingAddress()));
        orderDto.setShippingAddress(AddressMapper.toDto(order.getShippingAddress()));
        orderDto.setOrderItems(orderItems);
        return orderDto;
    }

    public static Order toEntity(OrderDto orderDto) {
        List<OrderItem> orderItems = orderDto.getOrderItems().stream()
                .map(OrderItemMapper::toEntity)
                .collect(Collectors.toList());

        Order order = new Order();
        order.setId(orderDto.getId());
        order.setCustomer(CustomerMapper.toEntity(orderDto.getCustomer()));
        order.setBillingAddress(AddressMapper.toEntity(orderDto.getBillingAddress()));
        order.setShippingAddress(AddressMapper.toEntity(orderDto.getShippingAddress()));
        order.setOrderItems(orderItems);
        return order;
    }
}
