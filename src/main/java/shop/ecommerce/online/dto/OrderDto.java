package shop.ecommerce.online.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private CustomerDto customer;
    private AddressDto billingAddress;
    private AddressDto shippingAddress;
    private List<OrderItemDto> orderItems;
}
