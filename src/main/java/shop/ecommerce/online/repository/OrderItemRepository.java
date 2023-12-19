package shop.ecommerce.online.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.ecommerce.online.dto.OrderItemDto;
import shop.ecommerce.online.model.Order;
import shop.ecommerce.online.model.OrderItem;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(Order order);
}
