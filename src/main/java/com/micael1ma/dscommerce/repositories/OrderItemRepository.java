package com.micael1ma.dscommerce.repositories;

import com.micael1ma.dscommerce.entities.OrderItem;
import com.micael1ma.dscommerce.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}


