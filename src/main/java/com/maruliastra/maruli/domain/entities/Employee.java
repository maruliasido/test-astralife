package com.maruliastra.maruli.domain.entities;

import com.maruliastra.maruli.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Table
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_no")
    private Integer empNo;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender", columnDefinition = "enum")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @OneToMany(mappedBy = "departmentEmployeeId.employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DepartmentEmployee> departmentEmployees;

    @OneToMany(mappedBy = "salaryId.employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Salary> salaries;

    @OneToMany(mappedBy = "titleId.employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Title> titles;

    @OneToMany(mappedBy = "departmentManagerId.employee", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DepartmentManager> departmentManagers;


}
