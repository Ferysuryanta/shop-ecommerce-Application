package shop.ecommerce.online.service.impl;

import org.springframework.stereotype.Service;
import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.mapper.AddressMapper;
import shop.ecommerce.online.mapper.CustomerMapper;
import shop.ecommerce.online.model.Address;
import shop.ecommerce.online.model.Customer;
import shop.ecommerce.online.repository.AddressRepository;
import shop.ecommerce.online.service.AddressService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;
    @Override
    public List<AddressDto> findAddressByCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        List<Address> addresses = repository.findByCustomer(customer);
        return addresses.stream().map(AddressMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Address address = AddressMapper.toEntity(addressDto);
        Address saveAddress = repository.save(address);
        return AddressMapper.toDto(saveAddress);
    }

    @Override
    public AddressDto updateAddress(Long addressId, AddressDto updateAddressDto) {
        Address existingAddress = repository.findById(addressId)
                .orElseThrow(() -> new NoSuchElementException("Address not found"));

        //update the existing address with the data
        existingAddress.setStreet(updateAddressDto.getStreet());
        existingAddress.setCity(updateAddressDto.getCity());
        existingAddress.setCity(updateAddressDto.getCity());
        existingAddress.setState(updateAddressDto.getState());
        existingAddress.setZipCode(updateAddressDto.getZipCode());
        existingAddress.setCustomer(CustomerMapper.toEntity(updateAddressDto.getCustomer()));
        return AddressMapper.toDto(existingAddress);
    }

    @Override
    public void deleteAddress(Long addressId) {
        repository.deleteById(addressId);
    }
}
