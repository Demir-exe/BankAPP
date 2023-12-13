package com.akdenizbank.mls.user.controller;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.user.EmployeeUser;
import com.akdenizbank.mls.user.service.EmployeeUserService;
import com.akdenizbank.mls.xaction.UpdateCustomerXAction;
import com.akdenizbank.mls.xaction.UpdateEmployeeUserXAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeUserController {
    @Autowired
    private EmployeeUserService employeeUserService;

    @GetMapping
    public GenericApiResponse getAllEmployees(Pageable pageable){
        Page<EmployeeUser> employeePage=this.employeeUserService.getAll(pageable);
        return new GenericApiResponse(200,"Success","123123",employeePage);
    }
    @GetMapping("/{id}")
    public  GenericApiResponse getEmployeeByID(@PathVariable String id){
        EmployeeUser employeeUserInDB=this.employeeUserService.getById(id);
        if (employeeUserInDB == null) {
            throw new RuntimeException("No such Employee");
        }
        return new GenericApiResponse(200,"Success","123123",employeeUserInDB);
    }
    @PatchMapping("/{id}")
    public GenericApiResponse updateEmployeeEMail(@PathVariable String id, @RequestBody UpdateEmployeeUserXAction xAction){
        EmployeeUser employeeUserInDB=this.employeeUserService.getById(id);
        if (employeeUserInDB == null) {
            throw new RuntimeException("No such Employee");
        }
        employeeUserInDB.setEmail(xAction.getEmail());
        employeeUserInDB=employeeUserService.create(employeeUserInDB);
        return new GenericApiResponse(200,"Success","123123",employeeUserInDB);
    }
    @DeleteMapping("/{id}")
    public GenericApiResponse deleteEmployee(@PathVariable String id){
        EmployeeUser employeeUserInDB= employeeUserService.getById(id);
        if (employeeUserInDB == null) {
            throw new RuntimeException("No such Employee");
        }
          this.employeeUserService.delete(id);
        return new GenericApiResponse(200,"Success","123123");
    }
}
