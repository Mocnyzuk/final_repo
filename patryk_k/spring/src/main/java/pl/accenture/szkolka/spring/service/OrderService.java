package pl.accenture.szkolka.spring.service;

import org.springframework.stereotype.Service;
import pl.accenture.szkolka.spring.model.Order;
import pl.accenture.szkolka.spring.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return new ArrayList<>(orderRepository.findAll());
    }
}
