package shop.ecommerce.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ecommerce.online.dto.OrderDto;
import shop.ecommerce.online.model.Address;
import shop.ecommerce.online.model.Customer;
import shop.ecommerce.online.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);

    List<Order> findByShippingAddress(Address shippingAddress);
}
