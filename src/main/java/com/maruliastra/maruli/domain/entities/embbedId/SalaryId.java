package com.maruliastra.maruli.domain.entities.embbedId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maruliastra.maruli.domain.entities.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Setter
@Getter
public class SalaryId implements Serializable {

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @Column(name = "from_date")
    private Date fromDate;


}
