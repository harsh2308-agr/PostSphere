package org.studyEasy.SpringStarter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

@Controller
public class AdminController {
    
    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }
    
}
