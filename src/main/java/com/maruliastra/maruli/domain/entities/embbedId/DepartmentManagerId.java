package com.maruliastra.maruli.domain.entities.embbedId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maruliastra.maruli.domain.entities.Department;
import com.maruliastra.maruli.domain.entities.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
public class DepartmentManagerId implements Serializable {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dept_no")
    private Department department;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "emp_no")
    private Employee employee;

}
