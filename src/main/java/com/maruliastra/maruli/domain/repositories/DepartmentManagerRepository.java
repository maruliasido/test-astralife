package com.maruliastra.maruli.domain.repositories;

import com.maruliastra.maruli.base.BaseRepository;
import com.maruliastra.maruli.domain.entities.DepartmentManager;
import com.maruliastra.maruli.domain.entities.embbedId.DepartmentManagerId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DepartmentManagerRepository extends BaseRepository<DepartmentManager, DepartmentManagerId> {

    public DepartmentManagerRepository(EntityManager em) {
        super(DepartmentManager.class, em);
    }


}
