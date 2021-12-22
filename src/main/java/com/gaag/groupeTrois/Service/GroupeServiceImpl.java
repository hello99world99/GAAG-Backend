package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public ArrayList<ArrayList<Groupe>> allApprenant(LocalDate anneee, int g, int a) {
        Promotion promotion = this.promotionServiceImpl.getPromotionByAnnee(anneee);
        this.listApprenant = apprenantService.listApprenantByPromotion(promotion);
        this.groupeList = new ArrayList<ArrayList<Groupe>>(g);

        System.out.println(this.groupeList);

        int counter = 0;
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

        for (int x=0; x<this.groupeList.size(); x++){
            System.out.println(this.groupeList.get(x));
            System.out.println("=======");
        }
        return this.groupeList;
    }

    @Override
    public List<Groupe> afficherAllGroupe() {
        return groupeRepository.findAll();
    }
}
