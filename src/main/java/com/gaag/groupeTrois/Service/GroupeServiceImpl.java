package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService{

    @Autowired
    GroupeRepository groupeRepository;

    @Autowired
    ApprenantServiceImpl apprenantService;

    @Autowired
    PromotionServiceImpl promotionServiceImpl;

    private List<Apprenant> listApprenant;
    private ArrayList<ArrayList<Groupe>> groupeList;

    public ArrayList<ArrayList<Groupe>> allApprenant(LocalDate annee, int nbrGroups, int nbrPerson, String trie, String method) {
        Promotion promotion = this.promotionServiceImpl.getPromotionByAnnee(annee);
        this.listApprenant = apprenantService.listApprenantByPromotion(promotion);
        if(trie.equals("aleatoire")){
            Collections.shuffle(this.listApprenant);
        }

        if (method.equals("exces")){
            nbrGroups+=1;
        }

        this.groupeList = new ArrayList<ArrayList<Groupe>>(nbrGroups);
        int counter = 0;
        System.out.println(nbrGroups);
        for (int x=0; x<nbrGroups; x++){
            this.groupeList.add(new ArrayList<Groupe>(nbrPerson));
            for (int i=0; i<this.listApprenant.size(); i++){
                while (this.groupeList.get(x).size()<nbrPerson){
                    Groupe group = new Groupe();
                    group.setApprenant(this.listApprenant.get(counter));
                    group.setTache("");
                    group.setNumeroGroupe(x);
                    group.setRound(2);
                    this.groupeList.get(x).add(group);
                    counter++;
                }
            }
        }

        if (nbrGroups*nbrPerson<this.listApprenant.size()){
            int rest = this.listApprenant.size()-(nbrGroups*nbrPerson);
            for (int x=0; x<rest; x++){
                int j=nbrGroups*nbrPerson;
                j+=x;
                Groupe group = new Groupe();
                group.setApprenant(this.listApprenant.get(j));
                group.setTache("");
                group.setNumeroGroupe(x);
                group.setRound(2);
                this.groupeList.get(x).add(group);
            }
        }

        return this.groupeList;
    }

    @Override
    public List<Groupe> afficherAllGroupe() {
        return groupeRepository.findAll();
    }
}
