package com.akdenizbank.mls.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.user.repository.CustomerUserRepository;

@Service
public class CustomerUserService {

    private CustomerUserRepository customerUserRepository;

    public CustomerUserService(CustomerUserRepository customerUserRepository) {
        this.customerUserRepository = customerUserRepository;
    }

    public CustomerUser create(CustomerUser customerUser) {
        return this.customerUserRepository.save(customerUser);
    }

    public CustomerUser getById(String id) {
        return this.customerUserRepository.findById(id).orElse(null);
    }

    public Page<CustomerUser> getAll(Pageable pageable) {
        return this.customerUserRepository.findAll(pageable);
    }

    public void delete(String id) {
        CustomerUser customerUserInDB = this.getById(id);
        if (customerUserInDB == null) {
            throw new RuntimeException("No Such Customer");
        }
        this.customerUserRepository.delete(customerUserInDB);
    }
}
