package com.michael.mediareview.media.auth;
import com.michael.mediareview.media.Media;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @SequenceGenerator(
            name = "media_sequence",
            sequenceName = "media_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "media_sequence"
    )
    private Long id;
    @Transient
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private String password;
    private String username;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialNonExpired;
    private boolean isEnabled;

    @OneToMany(
            mappedBy = "applicationUser" ,
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Media> medias = new ArrayList<>();
    public ApplicationUser(Set<? extends GrantedAuthority> grantedAuthorities,
                           String username, String password,
                           boolean isAccountNonExpired,
                           boolean isAccountNonLocked, boolean isCredentialNonExpired,
                           boolean isEnabled) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
    }

    public ApplicationUser(){

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
