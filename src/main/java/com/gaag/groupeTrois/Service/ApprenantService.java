package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;

import java.time.LocalDate;
import java.util.List;

interface AprpenantService {
    String ajouterApprenant(Apprenant apprenant);
    List<Apprenant> afficherListApprenant();
    String supprimerApprenantById(Long id);
    Apprenant modifierApprenant(Apprenant apprenant, Long id);
    public List<Apprenant> listApprenantByPromotion(LocalDate annee);
}
