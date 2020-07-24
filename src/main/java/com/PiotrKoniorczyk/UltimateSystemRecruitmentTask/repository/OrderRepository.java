package com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.repository;

import com.PiotrKoniorczyk.UltimateSystemRecruitmentTask.model.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("Select p From Order p")
    List<Order> findAllOrders(Pageable page);
}

