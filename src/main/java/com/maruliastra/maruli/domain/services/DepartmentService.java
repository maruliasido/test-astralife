package com.maruliastra.maruli.domain.services;

import com.maruliastra.maruli.domain.entities.Department;
import com.maruliastra.maruli.domain.repositories.DepartmentRepository;
import com.maruliastra.maruli.exception.CustomException.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    @Transactional
    public void addDepartment(Department department){
        if (department == null){
            throw new BusinessException("DepartmentService01|Department name cant't be empty");
        }

        Department isExist = departmentRepository.findByName(department.getDeptName());

        if (isExist != null){
            throw new BusinessException("DepartmentService01|Department name is exist");
        }

        Department dept = new Department();
        dept.setDeptName(department.getDeptName());

        departmentRepository.save(department);
    }

    @Transactional
    public void addDepartment(List<Department> departments){
        for (Department department : departments){
            addDepartment(department);
        }
    }

}
