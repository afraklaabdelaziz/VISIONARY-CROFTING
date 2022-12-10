package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Client;
import com.example.visionarycrofting.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @GetMapping("/client")
    public String login(){
        return "loginClient";
    }
    @PostMapping("/client")
    public String loginClient(String email,String password){
        clientService.loginClient(email,password);
        return "redirect:/client/page";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client){
        System.out.println(client);
        clientService.save(client);
        return "redirect:login";
    }
}
