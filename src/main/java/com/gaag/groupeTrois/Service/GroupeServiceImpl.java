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

    public ArrayList<ArrayList<Groupe>> allApprenant(LocalDate annee, int g, int a, String trier, String repart) {
        Promotion promotion = this.promotionServiceImpl.getPromotionByAnnee(annee);
        this.listApprenant = apprenantService.listApprenantByPromotion(promotion);
        if(trier.equals("aleatoire")){
            Collections.shuffle(this.listApprenant);
        }

        if (repart.equals("exces")){
            g+=1;
        }

        this.groupeList = new ArrayList<ArrayList<Groupe>>(g);
        int counter = 0;
        System.out.println(g);
        for (int x=0; x<g; x++){
            this.groupeList.add(new ArrayList<Groupe>(a));
            for (int i=0; i<this.listApprenant.size(); i++){
                while (this.groupeList.get(x).size()<a){
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

        if (g*a<this.listApprenant.size()){
            int rest = this.listApprenant.size()-(g*a);
            for (int x=0; x<rest; x++){
                int j=g*a;
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
