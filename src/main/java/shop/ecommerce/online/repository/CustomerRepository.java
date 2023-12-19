package shop.ecommerce.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByName(String name);

    @Query("select c from Customer c JOIN c.addresses a where a.city = :city")
    List<Customer> findByCity(@Param("city") String city);
}
