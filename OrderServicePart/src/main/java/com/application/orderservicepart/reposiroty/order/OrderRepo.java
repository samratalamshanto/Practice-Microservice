package com.application.orderservicepart.reposiroty.order;

import com.application.orderservicepart.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, Long> {
}
