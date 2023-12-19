package shop.ecommerce.online.service;

import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.dto.CustomerDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> findAddressByCustomer(CustomerDto customerDto);

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(Long addressId, AddressDto updateAddressDto);

    void deleteAddress(Long addressId);
}
