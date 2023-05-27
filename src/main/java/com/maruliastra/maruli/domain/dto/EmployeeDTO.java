package com.maruliastra.maruli.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EmployeeDTO {

    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;

    private Integer salary;
    private String salaryStartDate;
    private String salaryEndDate;

    private String title;
    private String titleStartDate;
    private String titleEndDate;

    private String deptNo;
    private String startDeptManagerDate;
    private String endDeptManagerDate;

//    private String deptartmentId;
    private String startDeptEmployeeDate;
    private String endDeptEmoloyeeDate;

}
