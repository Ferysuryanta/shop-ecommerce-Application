package shop.ecommerce.online.service;

import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.model.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> findCustomerByName(String name);

    List<CustomerDto> findCustomerByCity(String city);

    List<AddressDto> getAllAddressForCustomer(CustomerDto customerDto);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer);

    void deleteCustomer(Long customerId);
}
