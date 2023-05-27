package com.maruliastra.maruli.domain.repositories;

import com.maruliastra.maruli.base.BaseRepository;
import com.maruliastra.maruli.domain.entities.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
public class DepartmentRepository extends BaseRepository<Department, String> {

    public DepartmentRepository(EntityManager em) {
        super(Department.class, em);
    }

    public Department findByName(String name){
        Query query = em.createNativeQuery("SELECT * FROM departments WHERE dept_name = :name", Department.class);
        query.setParameter("name", name);

        try {
            return (Department) query.getSingleResult();
        }catch (NoResultException nre){
            return null;
        }

    }

    public Department findByDeptNo(String deptNo){
        Query query = em.createNativeQuery("SELECT * FROM departments WHERE dept_no = :deptNo", Department.class);
        query.setParameter("deptNo", deptNo);

        try {
            return (Department) query.getSingleResult();
        }catch (NoResultException nre){
            return null;
        }

    }

}
