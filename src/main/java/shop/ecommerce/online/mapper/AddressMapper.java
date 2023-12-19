package shop.ecommerce.online.mapper;

import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.model.Address;

public class AddressMapper {

    public static AddressDto toDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

    public static Address toEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setZipCode(addressDto.getZipCode());
        return address;
    }
}
