package com.gaag.groupeTrois.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nbrGroupe;
    private int numeroGroupe;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    @OneToMany
    private List<Apprenant> apprenant;
}
