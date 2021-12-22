package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Groupe;

import java.util.List;

public interface GroupeService {


    List<Groupe> afficherAllGroupe();

    void AjouterGroupe(Groupe groupe, int groupe_number);
}
