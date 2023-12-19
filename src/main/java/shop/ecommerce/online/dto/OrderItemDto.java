package shop.ecommerce.online.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.ecommerce.online.model.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long id;
    private ProductDto product;
    private int quantity;
    private OrderDto order;
}
