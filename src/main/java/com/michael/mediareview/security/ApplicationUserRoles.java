package com.michael.mediareview.security;
import com.google.common.collect.Sets;
import java.util.Set;
import static com.michael.mediareview.security.ApplicationUserPermissions.*;
public enum ApplicationUserRoles {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE,USER_UPDATE,USER_DELETE));

    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermissions> getPermissions() {
        return permissions;
    }
}
