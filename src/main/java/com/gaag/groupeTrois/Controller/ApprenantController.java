package com.gaag.groupeTrois.Controller;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Service.ApprenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/apprenant")
public class ApprenantController {

    @Autowired
    ApprenantServiceImpl apprenantServiceImp;

    @GetMapping("/afficher_list_apprenant")
    List<Apprenant> afficherListApprenant(){
        return apprenantServiceImp.afficherListApprenant();
    }
}
