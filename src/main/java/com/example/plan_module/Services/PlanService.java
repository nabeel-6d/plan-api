package com.example.plan_module.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.plan_module.Models.Plan;
import com.example.plan_module.Repository.PlanRepository;

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

    public List<Plan> retrieveAllPlans(){
        List<Plan> recievedData=new ArrayList<Plan>();
        planrepo.findAll().forEach(recievedData::add);

        return recievedData;
    }

    public Plan retrieveOnePlan(int id){
        return planrepo.findById(id).get();
    }
}
