package com.maruliastra.maruli.domain.controllers;

import com.maruliastra.maruli.domain.dto.EmployeeDTO;
import com.maruliastra.maruli.domain.entities.Employee;
import com.maruliastra.maruli.domain.services.EmployeeService;
import com.maruliastra.maruli.response.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


    @Autowired private EmployeeService employeeService;

    @GetMapping("/find/{id}")
    public HttpResponse<Employee> findById(@PathVariable String id){
        return new HttpResponse<>(employeeService.findById(id));
    }

    @GetMapping("/find-all")
    public HttpResponse<List<Employee>> findAllEmployee(){
        return new HttpResponse<>(employeeService.findAll());
    }

    @PostMapping("/add")
    public HttpResponse<String> addEmployees(@RequestBody List<EmployeeDTO> employeeDTOS){
        employeeService.addEmployees(employeeDTOS);
        return new HttpResponse<>("All employees has been added");
    }

    @DeleteMapping("/delete")
    public HttpResponse<String> deleteEmployee(@RequestParam Integer id){
        employeeService.deleteEmployee(id);
        return new HttpResponse<>("Employee has been deleted");
    }



}
