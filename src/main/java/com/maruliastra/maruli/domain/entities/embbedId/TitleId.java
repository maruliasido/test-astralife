package com.maruliastra.maruli.domain.entities.embbedId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maruliastra.maruli.domain.entities.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Setter
@Getter
public class TitleId implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "emp_no")
    private Employee employee;

    @Column(name = "title")
    private String title;

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

}
