package com.example.plan_module.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.plan_module.Models.Plan;

public interface PlanRepository extends CrudRepository<Plan,Integer>{
    
}
