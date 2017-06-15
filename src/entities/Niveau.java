/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Aimad.JAOUHAR
 */
@Entity
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numero;
    private String nom;
    private Float epaisseur;
    private int type;
    @OneToOne
    private RefStock refStock;

    public RefStock getRefStock() {
        return refStock;
    }

    public void setRefStock(RefStock refStock) {
        this.refStock = refStock;
    }
    
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(Float epaisseur) {
        this.epaisseur = epaisseur;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    

    
    @Override
    public String toString() {
        return "entities.Niveau[ num=" + numero + " ]";
    }
    
}
