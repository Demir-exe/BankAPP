package com.akdenizbank.mls.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akdenizbank.mls.user.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
