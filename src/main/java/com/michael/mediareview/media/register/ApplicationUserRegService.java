package com.michael.mediareview.media.register;

import com.michael.mediareview.media.auth.ApplicationUser;
import com.michael.mediareview.media.auth.ApplicationUserDao;
import com.michael.mediareview.media.auth.ApplicationUserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserRegService {
    ApplicationUserDaoService applicationUserDaoService;
    ApplicationUserDao applicationUserDao;

    @Autowired
    public ApplicationUserRegService(ApplicationUserDaoService applicationUserDaoService, ApplicationUserDao applicationUserDao){
        this.applicationUserDaoService = applicationUserDaoService;
        this.applicationUserDao = applicationUserDao;
    }

    public void signUpUser(ApplicationUserRegister user) {
        Optional<ApplicationUser> applicationUser = applicationUserDao.findApplicationUserByUsername(user.getUsername());
        if(applicationUser.isPresent()){
            throw new IllegalStateException("User already exists!");
        }
        applicationUserDaoService.addApplicationUser(user);
    }
}
