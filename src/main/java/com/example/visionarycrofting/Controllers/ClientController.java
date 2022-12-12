package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.Client;
import com.example.visionarycrofting.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService clientService;

    @GetMapping("/login")
    public String login(){
        return "loginClient";
    }
    @PostMapping("/login")
    public String loginClient(@ModelAttribute Client client , Model model, HttpSession session){
        session.setAttribute("client",clientService.findByEmail(client.getEmail()));
        if(clientService.loginClient(client.getEmail(),client.getPassword())){

            return "redirect:/produits";
        }else {
            model.addAttribute("error","mot de pass ou email es incorrect ");
            return "loginClient";
        }

    }
    @GetMapping("/register")
    public String register(){
        return "registerClient";
    }
    @PostMapping("/register")
    public String registerClient(@ModelAttribute Client client){
        System.out.println(client);
        clientService.save(client);
        return "redirect:login";
    }
}
