package com.maruliastra.maruli.domain.repositories;

import com.maruliastra.maruli.base.BaseRepository;
import com.maruliastra.maruli.domain.entities.Salary;
import com.maruliastra.maruli.domain.entities.embbedId.SalaryId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class SalaryRepository extends BaseRepository<Salary, SalaryId> {

    public SalaryRepository(EntityManager em) {
        super(Salary.class, em);
    }
}
