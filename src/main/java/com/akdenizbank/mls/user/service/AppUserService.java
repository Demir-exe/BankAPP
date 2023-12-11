package com.akdenizbank.mls.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.user.AppUser;
import com.akdenizbank.mls.user.repository.AppUserRepository;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    //CREATE
    public AppUser create(AppUser appUser) {
        return this.appUserRepository.save(appUser);
    }

    //READ
    public AppUser getById(String id) {
        return this.appUserRepository.findById(id).orElse(null);
    }

    //READ
    public Page<AppUser> getAll(Pageable pageable) {
        return this.appUserRepository.findAll(pageable);
    }

    
    public void delete(String id) {
        AppUser userInDB = this.getById(id);
        if (userInDB == null) {
            throw new RuntimeException("No Such User");
        }
        appUserRepository.delete(userInDB);
    }
}
