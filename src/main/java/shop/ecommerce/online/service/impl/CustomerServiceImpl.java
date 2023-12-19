package shop.ecommerce.online.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.mapper.AddressMapper;
import shop.ecommerce.online.mapper.CustomerMapper;
import shop.ecommerce.online.model.Address;
import shop.ecommerce.online.model.Customer;
import shop.ecommerce.online.repository.CustomerRepository;
import shop.ecommerce.online.service.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Override
    public List<CustomerDto> findCustomerByName(String name) {
        List<Customer> customers = repository.findByName(name);
        return customers.stream().map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> findCustomerByCity(String city) {
        List<Customer> customers = repository.findByCity(city);
        return customers.stream().map(CustomerMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<AddressDto> getAllAddressForCustomer(CustomerDto customerDto) {
        Customer cust = CustomerMapper.toEntity(customerDto);
        List<Address> addresses = cust.getAddresses();
        return addresses.stream().map(AddressMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer saveCustomer = repository.save(customer);
        return CustomerMapper.toDto(saveCustomer);
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updateCustomer) {

        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {

    }
}
