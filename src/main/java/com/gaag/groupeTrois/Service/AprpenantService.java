package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;

import java.util.List;

public interface AprpenantService {
    Apprenant ajouterApprenant(Apprenant apprenant);
    List<Apprenant> afficherListApprenant();
    void supprimerById(Long id);
    Apprenant modifierApprenant(Apprenant apprenant, Long id);
}
