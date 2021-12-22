package com.gaag.groupeTrois.Controller;

import com.gaag.groupeTrois.Model.Apprenant;
import com.gaag.groupeTrois.Model.Promotion;
import com.gaag.groupeTrois.Service.PromotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/promotion")
public class PromotionController {
    @Autowired
    PromotionServiceImpl promotionService;

    @GetMapping("/afficher")
    List<Promotion> afficherPromotion(){
        return promotionService.afficherPromotion();
    }

    @PostMapping("/ajouter")
    Promotion ajouter_promotion(@RequestBody Promotion promotion){
        return promotionService.ajouterPromotion(promotion);
    }

    @PutMapping("/modifier/{id}")
    Promotion modifierPromotion(@RequestBody Promotion promotion,@PathVariable Long id){
        return promotionService.modifierPromotion(promotion, id);
    }

    @DeleteMapping("/supprimer/{id}")
    String supprimerPromotion(@PathVariable Long id){
        return promotionService.supprimerPromotionById(id);
    }

}
