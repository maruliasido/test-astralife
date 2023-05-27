package com.maruliastra.maruli.domain.entities;

import com.maruliastra.maruli.domain.entities.embbedId.DepartmentEmployeeId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "dept_emp")
public class DepartmentEmployee {

    @EmbeddedId
    private DepartmentEmployeeId departmentEmployeeId;

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

}
