// package com.example.plan_module.planapi_main;

// import java.util.LinkedHashSet;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// // import org.springframework.web.client.RestTemplate;

// @Service
// public class SubscriberPlan {
//     private int subscriber_id;
//     private Set<Plan> plans;
//     //private RestTemplate rest;
//     @Autowired
//     private PlanRepository planrepo;

//     public SubscriberPlan() {
//     }
//     public int getSubscriber_id() {
//         return subscriber_id;
//     }
//     public void setSubscriber_id(int subscriber_id) {
//         this.subscriber_id = subscriber_id;
//     }
//     public Set<Plan> getPlans() {
//         Set<Plan> recievedData=new LinkedHashSet<Plan>();
//         planrepo.findAll().forEach(recievedData::add);

//         return recievedData;  
//     }
//     public void setPlans() {
//         planrepo.findAll().forEach(p -> {
//            //Subscriber sub= rest.getForObject("localhost://8081/subscriber/get/"+p.getPlan_id(), Subscriber.class);
//         });
//     }

// }
