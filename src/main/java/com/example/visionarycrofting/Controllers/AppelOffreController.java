package com.example.visionarycrofting.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appelOffre")
public class AppelOffreController {
    @GetMapping("/")
    public String appelOffre(Model model){
        model.addAttribute("appel","appelOffre");
        return "appelOffre";
    }
}
