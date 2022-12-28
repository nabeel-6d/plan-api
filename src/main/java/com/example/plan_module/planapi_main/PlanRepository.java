package com.example.plan_module.planapi_main;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlanRepository extends PagingAndSortingRepository<Plan,Integer>{
    List<Plan> findByValidity(Date validity,Pageable pageable);
    List<Plan> findByCreationDate(Date creationDate,Pageable pageable);
    List<Plan> findByUpdationDate(Date updationDate,Pageable pageable);
}
