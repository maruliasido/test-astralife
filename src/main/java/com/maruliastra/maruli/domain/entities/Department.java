package com.maruliastra.maruli.domain.entities;


import com.maruliastra.maruli.utils.RandomUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "dept_name", unique = true)
    private String deptName;

    @OneToMany(mappedBy = "departmentEmployeeId.department", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DepartmentEmployee> departmentEmployees;

    @OneToMany(mappedBy = "departmentManagerId.department", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DepartmentManager> departmentManagers;


    @PrePersist
    private void prePersist(){
        this.deptNo =  RandomUtil.generateRandomString(4);
    }

}
