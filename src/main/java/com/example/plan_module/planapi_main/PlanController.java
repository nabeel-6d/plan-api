package com.example.plan_module.planapi_main;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plans")
public class PlanController {

    @Autowired
    private PlanService service;

    @PostMapping("/add")
    public void add(@RequestBody Plan plan){
        service.addPlan(plan);
    }

    @DeleteMapping("/delete/{plan_id}")
    public void delete(@PathVariable(name ="plan_id") int id){
        service.deletePlan(id);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Plan plan,@PathVariable int id){
        service.updateAPlan(plan,id);
    }

    @GetMapping("/giveplans")
    public List<Plan> retrieve(){
       return service.retrieveAllPlans();
    }

    @GetMapping("/giveplans/{plan_id}")
    public Plan retrieveOne(@PathVariable int plan_id){
        return service.retrieveOnePlan(plan_id);
    }
}
