package com.example.plan_module.planapi_main;

import java.sql.Date;
import java.time.LocalDate;

public class Dummy {
    public static void main(String[] args) {
        // Date d=new Date(System.currentTimeMillis());
        // System.out.println(" \n\n"+d);
        // String name="yes";
        // System.out.println('%'+name+'%');

       
        String year="2000";
        LocalDate local = LocalDate.parse(year);
        local.getYear();
        local.getMonth();
        local.getDayOfMonth();

        System.out.println("year is ------"+ local.getYear());
        System.out.println("month is ------"+local.getMonth());
        System.out.println("day is ------"+   local.getDayOfMonth());

    }
}
/*
 * 
 * 
 * nigaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 */