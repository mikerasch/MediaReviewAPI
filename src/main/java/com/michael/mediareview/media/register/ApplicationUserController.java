package com.michael.mediareview.media.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class ApplicationUserController {
private final ApplicationUserRegService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserRegService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new ApplicationUserRegister());
        return "register";
    }

    @PostMapping("/register")
    public String signUp(@ModelAttribute(value = "user") ApplicationUserRegister user){
        try{
            applicationUserService.signUpUser(user);
        }
        catch(IllegalStateException e){
            return "register";
        }
        return "redirect:/login";
    }
}
