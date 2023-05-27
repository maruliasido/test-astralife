package com.maruliastra.maruli.domain.services;

import com.maruliastra.maruli.domain.dto.EmployeeDTO;
import com.maruliastra.maruli.domain.entities.*;
import com.maruliastra.maruli.domain.entities.embbedId.DepartmentEmployeeId;
import com.maruliastra.maruli.domain.entities.embbedId.DepartmentManagerId;
import com.maruliastra.maruli.domain.entities.embbedId.SalaryId;
import com.maruliastra.maruli.domain.entities.embbedId.TitleId;
import com.maruliastra.maruli.domain.repositories.*;
import com.maruliastra.maruli.enums.Gender;
import com.maruliastra.maruli.exception.CustomException.BusinessException;
import com.maruliastra.maruli.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired private SalaryRepository salaryRepository;
    @Autowired private TitleRepository titleRepository;
    @Autowired private DepartmentManagerRepository departmentManagerRepository;
    @Autowired private DepartmentEmployeeRepository departmentEmployeeRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(String id){

        if (id == null){
            throw new BusinessException("EmployeeService01|ID can't be empty");
        }

        try {
            Integer.parseInt(id);
        }catch (NumberFormatException nfe){
            throw new BusinessException("EmployeeService01|ID must be a number");
        }

        try {
            return employeeRepository.findById(Integer.parseInt(id)).get();
        }catch (NoSuchElementException nsce){
            return null;
        }
    }

    @Transactional
    public void addEmployee(EmployeeDTO dto){

        employeeAddValidation(dto);

        //set employee
        Employee employee = new Employee();
        employee.setBirthdate(TimeUtil.convertStringToDate(dto.getBirthDate(),"dd-MM-yyyy"));
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());

        try {
            Gender.of(dto.getGender());
        }catch (IllegalArgumentException iae){
            throw new BusinessException("EmployeeService05|Fill gender with M/F only");
        }

        employee.setGender(Gender.of(dto.getGender()));
        employee.setHireDate(TimeUtil.convertStringToDate(dto.getHireDate(),"dd-MM-yyyy"));
        employeeRepository.save(employee);

        //set title
        Title title = new Title();
        TitleId titleId = new TitleId();
        titleId.setTitle(dto.getTitle());
        titleId.setEmployee(employee);
        titleId.setFromDate(TimeUtil.convertStringToDate(dto.getTitleStartDate(),"dd-MM-yyyy"));
        title.setTitleId(titleId);
        title.setToDate(TimeUtil.convertStringToDate(dto.getTitleEndDate(),"dd-MM-yyyy"));
        titleRepository.save(title);

        //set dept manager
        DepartmentManager departmentManager = new DepartmentManager();
        DepartmentManagerId departmentManagerId = new DepartmentManagerId();
        departmentManagerId.setEmployee(employee);

        Department department = departmentRepository.findByDeptNo(dto.getDeptNo());
        if (department == null){
            throw new BusinessException("EmployeeService20|Department no is not exist");
        }
        departmentManagerId.setDepartment(department);
        departmentManager.setFromDate(TimeUtil.convertStringToDate(dto.getStartDeptManagerDate(),"dd-MM-yyyy"));
        departmentManager.setToDate(TimeUtil.convertStringToDate(dto.getEndDeptManagerDate(),"dd-MM-yyyy"));
        departmentManager.setDepartmentManagerId(departmentManagerId);
        departmentManagerRepository.save(departmentManager);

        //set department employee
        DepartmentEmployee departmentEmployee = new DepartmentEmployee();
        DepartmentEmployeeId departmentEmployeeId = new DepartmentEmployeeId();
        departmentEmployeeId.setEmployee(employee);
        departmentEmployeeId.setDepartment(department);

        departmentEmployee.setDepartmentEmployeeId(departmentEmployeeId);
        departmentEmployee.setFromDate(TimeUtil.convertStringToDate(dto.getStartDeptEmployeeDate(),"dd-MM-yyyy"));
        departmentEmployee.setToDate(TimeUtil.convertStringToDate(dto.getEndDeptEmoloyeeDate(),"dd-MM-yyyy"));
        departmentEmployeeRepository.save(departmentEmployee);

        //set salary
        Salary salary = new Salary();
        salary.setSalary(dto.getSalary());
        SalaryId salaryId = new SalaryId();
        salaryId.setEmployee(employee);
        salaryId.setFromDate(TimeUtil.convertStringToDate(dto.getSalaryStartDate(), "dd-MM-yyyy"));
        salary.setSalaryId(salaryId);
        salary.setToDate(TimeUtil.convertStringToDate(dto.getSalaryEndDate(),"dd-MM-yyyy"));
        salaryRepository.save(salary);


    }

    @Transactional
    public void addEmployees(List<EmployeeDTO> dtos){
        for (EmployeeDTO dto : dtos){
            addEmployee(dto);
        }
    }

    @Transactional
    public void deleteEmployee(Integer id){
        Employee employee = findById(id.toString());

        if (employee != null){
            employeeRepository.delete(employee);
        }else {
            throw new BusinessException("DeleteService01|Employee is not exists");
        }

    }

    private void employeeAddValidation(EmployeeDTO dto){
        if (dto.getBirthDate() == null){
            throw new BusinessException("EmployeeService02|Birthdate can't be empty");
        }

        if (dto.getFirstName() == null){
            throw new BusinessException("EmployeeService03|First name can't be empty");
        }

        if (dto.getLastName() == null){
            throw new BusinessException("EmployeeService04|Last name can't be empty");
        }

        if (dto.getGender() == null){
            throw new BusinessException("EmployeeService05|Gender can't be empty");
        }

        if (dto.getHireDate() == null){
            throw new BusinessException("EmployeeService06|Hire date can't be empty");
        }

        if (dto.getSalary() == null){
            throw new BusinessException("EmployeeService07|Salary can't be empty");
        }

         if (dto.getSalaryEndDate() == null){
            throw new BusinessException("EmployeeService08|Salary end date can't be empty");
        }

         if (dto.getSalaryStartDate() == null){
             throw new BusinessException("EmployeeService09|Salary start can't be empty");
        }

         if (dto.getTitle() == null){
             throw new BusinessException("EmployeeService10|Title can't be empty");
        }

         if (dto.getTitleStartDate() == null){
             throw new BusinessException("EmployeeService11|Title start date can't be empty");
        }

         if (dto.getTitleEndDate() == null){
             throw new BusinessException("EmployeeService12|Title end date can't be empty");
        }

         if (dto.getDeptNo() == null){
             throw new BusinessException("EmployeeService13|Dept no can't be empty");
        }

         if (dto.getStartDeptManagerDate() == null){
             throw new BusinessException("EmployeeService14|Start dept manager date can't be empty");
        }

         if (dto.getEndDeptManagerDate() == null){
             throw new BusinessException("EmployeeService15|End dept manager date  can't be empty");
        }

//         if (dto.getDeptartmentId() == null){
//             throw new BusinessException("EmployeeService16|Birthdate can't be empty");
//        }

         if (dto.getStartDeptEmployeeDate() == null){
             throw new BusinessException("EmployeeService17|Start dept employee date  can't be empty");
        }

         if (dto.getEndDeptEmoloyeeDate() == null){
             throw new BusinessException("EmployeeService18|End dept employee date  can't be empty");
        }



    }

}
