package com.michael.mediareview.media.Admin;
import com.michael.mediareview.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "admin/panel")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public List<Media> getMedia(){
        return adminService.getMedia();
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping(path = "/delete")
    public void deleteAll(){
        adminService.deleteAll();
    }
}
