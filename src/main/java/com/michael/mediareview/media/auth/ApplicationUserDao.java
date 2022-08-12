package com.michael.mediareview.media.auth;

import com.michael.mediareview.media.register.ApplicationUserRegister;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser,Long> {
    Optional<ApplicationUser> findApplicationUserByUsername(String username);
}
