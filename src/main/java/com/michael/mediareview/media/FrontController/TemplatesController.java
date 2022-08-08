package com.michael.mediareview.media.FrontController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class TemplatesController {

    @GetMapping("login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("media-review")
    public String getMediaReviewer() {
        return "media-review";
    }
}
