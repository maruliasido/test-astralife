package com.maruliastra.maruli.domain.repositories;

import com.maruliastra.maruli.base.BaseRepository;
import com.maruliastra.maruli.domain.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeRepository extends BaseRepository<Employee, Integer> {

    public EmployeeRepository(EntityManager em) {
        super(Employee.class, em);
    }

}
