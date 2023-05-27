package com.maruliastra.maruli.domain.entities;

import com.maruliastra.maruli.domain.entities.embbedId.DepartmentManagerId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "dept_manager")
public class DepartmentManager {

    @EmbeddedId
    private DepartmentManagerId departmentManagerId;

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

}
