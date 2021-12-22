package com.gaag.groupeTrois.Repository;

import com.gaag.groupeTrois.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    //public List<Apprenant> findAll();

}
