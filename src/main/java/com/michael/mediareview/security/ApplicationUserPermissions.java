package com.michael.mediareview.security;

public enum ApplicationUserPermissions {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_DELETE("user:delete"),
    USER_UPDATE("user:update");

    private final String permission;

    ApplicationUserPermissions(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}

