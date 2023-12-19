package shop.ecommerce.online.mapper;

import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.model.Address;
import shop.ecommerce.online.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerDto toDto(Customer customer) {
        List<AddressDto> addresses = customer.getAddresses().stream()
                .map(AddressMapper::toDto)
                .toList();

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAddresses(addresses);
        return customerDto;
    }

    public static Customer toEntity(CustomerDto customerDto) {

        List<Address> addresses = customerDto.getAddresses().stream()
                .map(AddressMapper::toEntity)
                .toList();
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setAddresses(addresses);
        return customer;
    }
}
