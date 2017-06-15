/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Aimad.JAOUHAR
 */
@Entity
public class IndexA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long numOrdre;
    @ManyToOne(fetch = FetchType.EAGER)
    private Operation operation;
    @ManyToOne
    private Niveau niveau;
    private int tempsOp;

    public Long getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Long numOrdre) {
        this.numOrdre = numOrdre;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getTempsOp() {
        return tempsOp;
    }

    public void setTempsOp(int tempsOp) {
        this.tempsOp = tempsOp;
    }
    
    @Override
    public String toString() {
        return "entities.IndexA[ numOrdre=" + numOrdre + " ]";
    }

}
