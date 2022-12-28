package com.example.plan_module.planapi_main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.sql.Date;

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
    public Collection<Plan> retrieve(){
       return service.retrieveAllPlans();
    }

    @GetMapping("/giveplans/{plan_id}")
    public Plan retrieveOne(@PathVariable int plan_id){
        return service.retrieveOnePlan(plan_id);
    }

    @GetMapping("/giveplans/byvalidity/{validity}")
    public Collection<Plan> allPlansByValidity(@PathVariable String validity){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlFormattedDate=null;
        try {
            java.util.Date date=sdf.parse(validity);
            sqlFormattedDate=new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return service.retrievePlansByValidity(sqlFormattedDate);
    }

    @GetMapping("/giveplans/bydatecreated/{createdate}")
    public Collection<Plan> allPlansByCreationDate(@PathVariable String createdate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlFormattedDate=null;
        try {
            java.util.Date date=sdf.parse(createdate);
            sqlFormattedDate=new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return service.retrievePlansByCreationDate(sqlFormattedDate);
    }

    @GetMapping("/giveplans/bydatemodified/{modifieddate}")
    public Collection<Plan> allPlansByUpdationDate(@PathVariable String modifieddate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlFormattedDate=null;
        try {
            java.util.Date date=sdf.parse(modifieddate);
            sqlFormattedDate=new Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return service.retrievePlansByUpdationDate(sqlFormattedDate);
    }

}
