package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService{

    @Autowired
    GroupeRepository groupeRepository;

    Groupe groupeInstance;


    @Override
    public List<Groupe> afficherAllGroupe() {
        return groupeRepository.findAll();
    }

    @Override
    public void AjouterGroupe(Groupe groupe, int groupe_number) {

        for(int i=0 ; i <= groupe_number; i++){
            groupeInstance  = new Groupe();

            groupeInstance.setNom_groupe("Groupe " + i);
            groupeRepository.save(groupeInstance);
        }



    }


}
