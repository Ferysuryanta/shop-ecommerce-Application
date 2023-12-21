package shop.ecommerce.online.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.ecommerce.online.model.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private CustomerDto customer;
}
