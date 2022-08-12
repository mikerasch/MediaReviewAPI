package com.michael.mediareview.media.auth;

import com.michael.mediareview.media.register.ApplicationUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import static com.michael.mediareview.security.ApplicationUserRoles.USER;

@Repository
public class ApplicationUserDaoService {

    private PasswordEncoder passwordEncoder;
    private ApplicationUserDao applicationUserDao;
    @Autowired
    public ApplicationUserDaoService(PasswordEncoder passwordEncoder, ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<ApplicationUser> selectApplicationUserByUsername(String userName) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> userName.equals(applicationUser.getUsername()))
                .findFirst();
    }

    public void addApplicationUser(ApplicationUserRegister user){
        applicationUserDao.save(
                new ApplicationUser(
                        USER.getGrantedAuthorities(),
                        user.getUsername(),
                        passwordEncoder.encode(user.getPassword()),
                        true,
                        true,
                        true,
                        true
                )
        );
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = applicationUserDao.findAll();
        return applicationUsers;
    }
}
