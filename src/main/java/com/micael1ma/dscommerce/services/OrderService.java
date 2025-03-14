package com.micael1ma.dscommerce.services;

import com.micael1ma.dscommerce.dto.OrderDTO;
import com.micael1ma.dscommerce.entities.Order;
import com.micael1ma.dscommerce.repositories.OrderRepository;
import com.micael1ma.dscommerce.services.execptions.ResourceNotFoundExeception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeception("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
