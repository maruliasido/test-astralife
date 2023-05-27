package com.maruliastra.maruli.domain.repositories;

import com.maruliastra.maruli.base.BaseRepository;
import com.maruliastra.maruli.domain.entities.DepartmentEmployee;
import com.maruliastra.maruli.domain.entities.embbedId.DepartmentEmployeeId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DepartmentEmployeeRepository extends BaseRepository<DepartmentEmployee, DepartmentEmployeeId> {

    public DepartmentEmployeeRepository(EntityManager em) {
        super(DepartmentEmployee.class, em);
    }

}
