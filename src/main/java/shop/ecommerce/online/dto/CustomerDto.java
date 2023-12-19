package shop.ecommerce.online.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;
    private String name;
    private List<AddressDto> addresses;
}
