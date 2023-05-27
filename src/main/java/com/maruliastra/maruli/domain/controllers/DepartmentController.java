package com.maruliastra.maruli.domain.controllers;

import com.maruliastra.maruli.domain.entities.Department;
import com.maruliastra.maruli.domain.services.DepartmentService;
import com.maruliastra.maruli.response.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired private DepartmentService departmentService;

    @GetMapping("/find-all")
    public HttpResponse<List<Department>> findAll(){
        return new HttpResponse<>(departmentService.getAllDepartment());
    }

    @PostMapping("/add")
    public HttpResponse<String> addDepartments(@RequestBody List<Department> departments){
        departmentService.addDepartment(departments);
        return new HttpResponse<>("Department succesfully added");
    }

}
