package com.gaag.groupeTrois.Service;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Groupe;
import com.gaag.groupeTrois.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class GroupeServiceImpl implements GroupeService{

    @Autowired
    GroupeRepository groupeRepository;

    @Autowired
    ApprenantServiceImpl apprenantService;

    private List<Apprenant> listApprenant;

    public List<Apprenant> allApprenant(LocalDate anneee) {
        this.listApprenant = apprenantService.listApprenantByPromotion(anneee);
        return  this.listApprenant;
    }

    @Override
    public List<Groupe> afficherAllGroupe() {
        return groupeRepository.findAll();
    }
}
