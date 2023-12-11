package com.akdenizbank.mls.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akdenizbank.mls.user.CustomerUser;

public interface CustomerUserRepository extends JpaRepository<CustomerUser, String> {

}
