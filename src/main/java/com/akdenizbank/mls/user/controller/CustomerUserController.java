package com.akdenizbank.mls.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.user.service.CustomerUserService;
import com.akdenizbank.mls.xaction.UpdateCustomerXAction;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerUserController {

    @Autowired
    private CustomerUserService customerUserService;

    @GetMapping
    public GenericApiResponse getAllCustomers(Pageable pageable) {
        Page<CustomerUser> customersPage = this.customerUserService.getAll(pageable);
        return new GenericApiResponse(200, "Success", "32861549", customersPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getCustomerById(@PathVariable String id) {
        CustomerUser customerInDB = this.customerUserService.getById(id);
        if (customerInDB == null) {
            throw new RuntimeException("No Such Customer");
        }
        return new GenericApiResponse(200, "Success", "234861423", customerInDB);
    }

    @PatchMapping("/{id}")
    public GenericApiResponse updateCustomerEmail(@PathVariable String id, @RequestBody UpdateCustomerXAction xaction) {
        CustomerUser customerInDB = this.customerUserService.getById(id);
        if (customerInDB == null) {
            throw new RuntimeException("No Such Customer");
        }
        customerInDB.setEmail(xaction.getEmail());
        customerInDB = customerUserService.create(customerInDB);
        return new GenericApiResponse(200, "Success", "456897", customerInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteCustomer(@PathVariable String id) {
        this.customerUserService.delete(id);
        return new GenericApiResponse(200, "Success", "9237549");
    }
}
