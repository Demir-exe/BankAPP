package com.akdenizbank.mls.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.user.AppUser;
import com.akdenizbank.mls.user.service.AppUserService;

@RestController
@RequestMapping("api/v1/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public GenericApiResponse getAllUsers(Pageable pageable) {
        Page<AppUser> usersPage = this.appUserService.getAll(pageable);
        return new GenericApiResponse(200, "Success", "0001#0001", usersPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getUserById(@PathVariable String id) {
        AppUser userInDB = this.appUserService.getById(id);
        if (userInDB == null) {
            throw new RuntimeException("No Such User Found With Given id");
        }
        return new GenericApiResponse(200, "Success", "0001#0002", userInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteUser(@PathVariable String id) {
        this.appUserService.delete(id);
        return new GenericApiResponse(200, "Success", "0001#0003", "Successfully deleted");
    }

    // HTTP REQUESTS
    // GET - POST - PUT - DELETE - PATCH
    // 200 -> ok
    // 404 -> notfound
    // 400 -> bad parameters
    // 407 -> proxy auth required
    // 500 -> internal server error

    // CRUD

}
