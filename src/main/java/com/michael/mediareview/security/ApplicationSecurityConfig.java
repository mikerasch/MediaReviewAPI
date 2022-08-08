package com.michael.mediareview.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.michael.mediareview.security.ApplicationUserPermissions.*;
import static com.michael.mediareview.security.ApplicationUserRoles.*;
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // enable for production build
                .authorizeRequests()
                .antMatchers("index","/css/*","/js/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/media/**").hasAuthority(USER_READ.getPermission())
                .antMatchers(HttpMethod.POST,"/api/v1/media/**").hasAuthority(USER_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT,"/api/v1/media/**").hasAuthority(USER_UPDATE.getPermission())
                .antMatchers(HttpMethod.DELETE,"/api/v1/media/**").hasAuthority(USER_DELETE.getPermission())
                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/media-review",true);
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails testUser = User.builder()
                .username("test")
                .password(passwordEncoder.encode("password"))
//                .roles(USER.name())
                .authorities(USER.getGrantedAuthorities())
                .build();
        UserDetails michaelAdmin = User.builder()
                .username("michael")
                .password(passwordEncoder.encode("password"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                testUser,
                michaelAdmin
        );
    }
}
