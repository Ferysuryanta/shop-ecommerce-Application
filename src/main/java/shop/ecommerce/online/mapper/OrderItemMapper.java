package shop.ecommerce.online.mapper;

import shop.ecommerce.online.dto.OrderDto;
import shop.ecommerce.online.dto.OrderItemDto;
import shop.ecommerce.online.model.Order;
import shop.ecommerce.online.model.OrderItem;

public class OrderItemMapper {

    public static OrderItemDto toDto(OrderItem orderItem) {
        OrderItemDto itemDto = new OrderItemDto();
        itemDto.setId(orderItem.getId());
        itemDto.setProduct(ProductMapper.toDto(orderItem.getProduct()));
        itemDto.setQuantity(orderItem.getQuantity());
        itemDto.setOrder(OrderMapper.toDto(orderItem.getOrder()));
        return itemDto;
    }

    public static OrderItem toEntity(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDto.getId());
        orderItem.setProduct(ProductMapper.toEntity(orderItemDto.getProduct()));
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setOrder(OrderMapper.toEntity(orderItemDto.getOrder()));
        return orderItem;
    }
}
