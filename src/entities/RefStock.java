/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Aimad.JAOUHAR
 */
@Entity
public class RefStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Float epaisseur;
    @ManyToOne(fetch = FetchType.EAGER)
    private Niveau niveau;
    
    @OneToMany(mappedBy = "refStock")
    private List<Stock> stock;

    public Long getNumero() {
        return id;
    }

    public void setNumero(Long numero) {
        this.id = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
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

    public List<Stock> getStock() {
        return stock;
    }

    public void setStock(List<Stock> stock) {
        this.stock = stock;
    }

    
    

    @Override
    public String toString() {
        return "entities.RefStock[ id=" + id + " ]";
    }

}
