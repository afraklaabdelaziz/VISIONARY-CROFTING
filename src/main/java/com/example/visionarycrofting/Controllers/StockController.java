package com.example.visionarycrofting.Controllers;

import com.example.visionarycrofting.Entities.*;
import com.example.visionarycrofting.Services.IAppelOffreService;
import com.example.visionarycrofting.Services.IProduitService;
import com.example.visionarycrofting.Services.IStockService;
import com.example.visionarycrofting.Utiles.GenerateReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    IStockService stockService;
    @Autowired
    IProduitService produitService;
    @Autowired
    IAppelOffreService appelOffreService;
    @GetMapping("/allproduit")
    public String allProduits(Model model,HttpSession session,@PathParam("category") Category category){
        Stock stock = (Stock) session.getAttribute("stock");
        if (category != null){
            model.addAttribute("produits",produitService.findProuitsByCategoryAndStock(stock,category));
        }else {
            model.addAttribute("produits",produitService.findByStock(stock));
        }
        model.addAttribute("category", Category.values());
        return "produitsStock";
    }
    @PostMapping("/produits/add")
    public String addProduit(@ModelAttribute Produit produit){
        produitService.addProduit(produit);
        return "redirect:/stock/allproduit";
    }

    @PostMapping("/appelOffre/add")
    public String addAppelOffre(@ModelAttribute AppelOffre appelOffre){
        appelOffre.setStatusAppelOffre(StatusAppelOffre.OUVERTE);
        appelOffreService.addAppelOffre(appelOffre);
        return "redirect:/stock/allproduit";
    }

    @GetMapping("/login")
    public String login(){
        return "loginClient";
    }

    @PostMapping("/login")
    public String loginClient(@ModelAttribute Stock stock , Model model, HttpSession session){
        session.setAttribute("stock",stockService.findByEmail(stock.getEmail()));
        if(stockService.loginStock(stock.getEmail(),stock.getPassword())){

            return "redirect:allproduit";
        }else {
            model.addAttribute("error","mot de pass ou email es incorrect ");
            return "loginClient";
        }

    }
    @GetMapping("/mesappelsoffre")
    public String mesAppelsOffres(Model model, HttpSession session){
        Stock stock = (Stock) session.getAttribute("stock");
        model.addAttribute("appelOffres",appelOffreService.findAppelOffrsByStock(stock));
        return "appelsOffreStock";
    }
    @GetMapping("/register")
    public String register(){
        return "registerStock";
    }
    @PostMapping("/register")
    public String registerClient(@ModelAttribute Stock stock){
        stockService.saveStock(stock);
        return "redirect:login";
    }

}
