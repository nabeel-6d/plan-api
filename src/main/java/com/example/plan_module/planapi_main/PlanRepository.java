package com.example.plan_module.planapi_main;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlanRepository extends PagingAndSortingRepository<Plan,Integer>{
    List<Plan> findByValidity(Date validity,Pageable pageable);
    List<Plan> findByCreationDate(Date creationDate,Pageable pageable);
    List<Plan> findByUpdationDate(Date updationDate,Pageable pageable);

    /* ---------------------------- yearly retrieval ---------------------------- */
    @Query(value = "select * from plan as p WHERE (select Extract(YEAR FROM p.creation_date))=:creationYear",nativeQuery = true)
    List<Plan> findByCreationYear(int creationYear,Pageable pageable);
    @Query(value = "select * from plan as p WHERE (select Extract(YEAR FROM p.validity))=:validity",nativeQuery = true)
    List<Plan> findByValidityYear(int validity,Pageable pageable);
    @Query(value = "select * from plan as p WHERE (select Extract(YEAR FROM p.updation_date))=:updationYear",nativeQuery = true)
    List<Plan> findByUpdationYear(int updationYear,Pageable pageable);

    /* ---------------------------- monthly retrieval --------------------------- */
    @Query(value = "select * from plan as p WHERE (select Extract(MONTH FROM p.creation_date))=:creationMonth",nativeQuery = true)
    List<Plan> findByCreationMonth(int creationMonth,Pageable pageable);
    @Query(value = "select * from plan as p WHERE (select Extract(MONTH FROM p.validity))=:validityInMonth",nativeQuery = true)
    List<Plan> findByValidityMonth(int validityInMonth,Pageable pageable);
    @Query(value = "select * from plan as p WHERE (select Extract(MONTH FROM p.updation_date))=:updationMonth",nativeQuery = true)
    List<Plan> findByUpdationMonth(int updationMonth,Pageable pageable);
}


/*
 * select e EXTRACT(MONTH FROM e.creationDate)
 */