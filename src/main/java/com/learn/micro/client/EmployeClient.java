//package com.learn.micro.client;
//
//import com.learn.micro.module.Employee;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.service.annotation.GetExchange;
//import org.springframework.web.service.annotation.HttpExchange;
//
//import java.util.List;
//
//@HttpExchange
//public interface EmployeClient {
//
//    @GetExchange("/employee/department/{depid}")
//    public List<Employee> getDepartmentIDDetails(@PathVariable Long depid);
//
//}
