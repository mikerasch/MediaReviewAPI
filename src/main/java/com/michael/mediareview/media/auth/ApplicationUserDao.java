package com.michael.mediareview.media.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
