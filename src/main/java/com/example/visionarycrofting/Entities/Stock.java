package com.example.visionarycrofting.Entities;

import javax.persistence.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private String adresse;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String telephone;
    private String password;

    @OneToMany(mappedBy = "stock" ,fetch = FetchType.LAZY)
    private List<Produit> produits = new ArrayList<>();

    @OneToMany(mappedBy = "stock",fetch = FetchType.LAZY)
    private List<AppelOffre> appeleOffres = new ArrayList<>();

    public Stock(String nom, String adresse, String email, String telephone, String password, List<Produit> produits, List<AppelOffre> appeleOffres) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.produits = produits;
        this.appeleOffres = appeleOffres;
    }

    public Stock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public List<AppelOffre> getAppeleOffres() {
        return appeleOffres;
    }

    public void setAppeleOffres(List<AppelOffre> appeleOffres) {
        this.appeleOffres = appeleOffres;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", produits=" + produits +
                ", appeleOffres=" + appeleOffres +
                '}';
    }
}
