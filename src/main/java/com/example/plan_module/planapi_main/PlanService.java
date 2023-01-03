package com.example.plan_module.planapi_main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planrepo;

    public boolean addPlan(Plan plan){
        try {
            if(plan==null)
                throw new IllegalArgumentException("the plan object found null while adding plan----------------------");
            planrepo.save(plan);
            return true;
        } catch (IllegalArgumentException e) {
           e.printStackTrace();
           System.out.println("in plan service- in add catch---------------------------------");
        }
        return false;
    }

    public boolean deletePlan(int plan_id){
        try {
            if(plan_id<0)
                throw new IllegalArgumentException("plan id found null while deleting plan------------------------");
            planrepo.deleteById(plan_id);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("in plan service - in delete catch-------------------------------");
        }
        return false;
    }

    public void updateAPlan(Plan plan,int id){
        try {
            if(plan ==null)
                throw new IllegalArgumentException("plan object found null while updating the plan--------------------------");
            
            Plan b=planrepo.findById(id).get();
            b.setName(plan.getName());
            b.setValidity(plan.getValidity());
            planrepo.save(b);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("in plan service - in update catch------------------------------------");
        }
    }

    public Collection<Plan> retrieveAllPlans(){
        Pageable allPagedData=PageRequest.of(0, 10);
        return planrepo.findAll(allPagedData).getContent();
    }

    public Plan retrieveOnePlan(int id){
        return planrepo.findById(id).get();
    }

    public Collection<Plan> retrievePlansByValidity(Date validity){
        Pageable allPagedPlansByValidity=PageRequest.of(0, 10, Sort.by("validity").ascending());
        return planrepo.findByValidity(validity,allPagedPlansByValidity);
    }

    public Collection<Plan> retrievePlansByCreationDate(Date createDate){
        Pageable pagedPlansByCreationDate=PageRequest.of(0, 10, Sort.by("creationDate").ascending());
        return planrepo.findByCreationDate(createDate,pagedPlansByCreationDate);
    }

    public Collection<Plan> retrievePlansByUpdationDate(Date updateDate){
        Pageable pagedPlansByUpdationDate=PageRequest.of(0, 10, Sort.by("updationDate").ascending());
        return planrepo.findByUpdationDate(updateDate,pagedPlansByUpdationDate);      
    }
    
    public Collection<Plan> retrievePlansByCreationYear(int createDate){
        Pageable pagedPlansByCreatedDate=PageRequest.of(0, 10);
        return planrepo.findByCreationYear(createDate, pagedPlansByCreatedDate);
    }

    public Collection<Plan> retrievePlansByUpdationYear(int updateYear){
        Pageable pagedPlansByUpdationDate=PageRequest.of(0, 10);
        return planrepo.findByUpdationYear(updateYear, pagedPlansByUpdationDate);
    }

    public Collection<Plan> retrievePlansByValidityYear(int validity){
        Pageable pagedPlansByValidityDate=PageRequest.of(0, 10);
        return planrepo.findByValidityYear(validity, pagedPlansByValidityDate);
    }

    public Collection<Plan> retrievePlansByCreationMonth(int createDate){
        Pageable pagedPlansByCreatedDate=PageRequest.of(0, 10);
        return planrepo.findByCreationMonth(createDate, pagedPlansByCreatedDate);
    }

    public Collection<Plan> retrievePlansByUpdationMonth(int updateMonth){
        Pageable pagedPlansByUpdationDate=PageRequest.of(0, 10);
        return planrepo.findByUpdationMonth(updateMonth, pagedPlansByUpdationDate);
    }

    public Collection<Plan> retrievePlansByValidityMonth(int validity){
        Pageable pagedPlansByValidityDate=PageRequest.of(0, 10);
        return planrepo.findByValidityMonth(validity, pagedPlansByValidityDate);
    }
}
