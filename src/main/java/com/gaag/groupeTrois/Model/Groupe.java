package com.gaag.groupeTrois.Model;

import javax.persistence.*;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int nonbr_goupe;
    private int numero_groupe;

    @OneToOne
    @JoinColumn(name = "aprrenant_id")
    private Apprenant apprenant;

    public Groupe() {
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

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
}
