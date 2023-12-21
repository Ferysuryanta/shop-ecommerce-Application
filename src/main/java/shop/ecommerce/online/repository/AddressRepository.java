package shop.ecommerce.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ecommerce.online.dto.AddressDto;
import shop.ecommerce.online.model.Address;
import shop.ecommerce.online.model.Customer;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCustomer(Customer customer);
}
