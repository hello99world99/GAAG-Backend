package com.gaag.groupeTrois.Model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Apprenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Promotion promotion;

    private String nom;

    private String email;

    private String Telephone;

    @Enumerated(EnumType.STRING)
    private Etat etat;



    @OneToMany(mappedBy = "apprenant")
    private List<Groupe> groupe;


    public Apprenant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_complet() {
        return nom;
    }

    public void setNom_complet(String nom_complet) {
        this.nom = nom_complet;
    }

    public String getEmail() {
        return email;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }


    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public List<Groupe> getGroupe() {
        return groupe;
    }

    public void setGroupe(List<Groupe> groupe) {
        this.groupe = groupe;
    }
}
