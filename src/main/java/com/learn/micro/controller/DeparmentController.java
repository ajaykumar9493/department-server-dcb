package com.learn.micro.controller;

//import com.learn.micro.client.EmployeClient;
//import com.learn.micro.client.EmployeClient;
import com.learn.micro.module.Department;
import com.learn.micro.module.EmployeDeparment;
import com.learn.micro.module.Employee;
import com.learn.micro.repository.DepartmentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DeparmentController {

    private static final Logger LOGGER= LoggerFactory.getLogger(DeparmentController.class);

    @Autowired
    private DepartmentService departmentService;

//    @Autowired
//    private EmployeClient employeClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${employee.service.url}")
    private String empdepidurl;



    @GetMapping
    public List<Department> getdepatmentdetails(){
        LOGGER.info(">> Getting all departments :::");

       return departmentService.findAll();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info(">> Saving department details :: {}",department);


        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id){
        LOGGER.info(">> Getting department details based on ID :: {}", id);
        return departmentService.getReferenceById(id);
    }



    @GetMapping("/withemp")
    public List<EmployeDeparment> getAllData(){

        System.out.println(">>");
        List<EmployeDeparment> listEmpDep = new ArrayList<>();
        List<Department> listdepartment=departmentService.findAll();
        System.out.println(">> L");
        for(Department department: listdepartment){
            System.out.println(">> LIn >> Url "+empdepidurl);

            ResponseEntity<List<Employee>> response = restTemplate.exchange(empdepidurl + department.getId(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
            List<Employee> listemploye = response.getBody();

//            List<Employee> listemploye = employeClient.getDepartmentIDDetails(department.getId());
            System.out.println(">> got emp list");
            EmployeDeparment empdep = new EmployeDeparment(department, listemploye);
            System.out.println(">> Add");
            listEmpDep.add(empdep);
        }
        System.out.println(">>>");

        return listEmpDep;

    }

}
