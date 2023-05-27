package com.maruliastra.maruli.domain.entities;

import com.maruliastra.maruli.domain.entities.embbedId.SalaryId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "salaries")
public class Salary {

    @EmbeddedId
    private SalaryId salaryId;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "to_date")
    private Date toDate;
}
