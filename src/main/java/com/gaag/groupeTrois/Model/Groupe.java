package com.gaag.groupeTrois.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String nom_groupe;

    private int nonbr_goupe;

    private int numero_groupe;


    @Enumerated(EnumType.STRING)
    private Etat etat;

    @ManyToOne()
    private Apprenant apprenant;



    public Groupe() {
    }

    public Groupe(int nonbr_goupe) {
        this.nonbr_goupe = nonbr_goupe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNonbr_goupe() {
        return nonbr_goupe;
    }

    public void setNonbr_goupe(int nonbr_goupe) {
        this.nonbr_goupe = nonbr_goupe;
    }

    public int getNumero_groupe() {
        return numero_groupe;
    }

    public void setNumero_groupe(int numero_groupe) {
        this.numero_groupe = numero_groupe;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }


    public String getNom_groupe() {
        return nom_groupe;
    }

    public void setNom_groupe(String nom_groupe) {
        this.nom_groupe = nom_groupe;
    }

}
