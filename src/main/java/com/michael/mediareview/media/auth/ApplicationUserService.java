package com.michael.mediareview.media.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {
    private final ApplicationUserDaoService applicationUserDaoService;

    @Autowired
    public ApplicationUserService(ApplicationUserDaoService applicationUserDaoService) {
        this.applicationUserDaoService = applicationUserDaoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserDaoService.selectApplicationUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found!"));
    }
}
