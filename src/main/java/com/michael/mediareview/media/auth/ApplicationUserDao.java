package com.michael.mediareview.media.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser,Long> {

}
