package shop.ecommerce.online.service.impl;

import org.springframework.stereotype.Service;
import shop.ecommerce.online.dto.CustomerDto;
import shop.ecommerce.online.dto.OrderDto;
import shop.ecommerce.online.mapper.CustomerMapper;
import shop.ecommerce.online.mapper.OrderMapper;
import shop.ecommerce.online.model.Customer;
import shop.ecommerce.online.model.Order;
import shop.ecommerce.online.repository.OrderRepository;
import shop.ecommerce.online.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    @Override
    public List<OrderDto> findOrderByCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        List<Order> orders = repository.findByCustomer(customer);
        return orders.stream().map(OrderMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.toEntity(orderDto);
        Order saveOrder = repository.save(order);
        return OrderMapper.toDto(saveOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        repository.findById(orderId);
    }
}
