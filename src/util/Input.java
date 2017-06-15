/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.AffEquipement;
import entities.Casee;
import entities.Equipement;
import entities.Stock;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class Input {
    private List<Casee> casees;
    private List<Equipement> equipements;
    private List<AffEquipement> affEquipements;
    private List<Stock> stocks;

    public List<Casee> getCasees() {
        return casees;
    }

    public void setCasees(List<Casee> casees) {
        this.casees = casees;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<AffEquipement> getAffEquipements() {
        return affEquipements;
    }

    public void setAffEquipements(List<AffEquipement> affEquipements) {
        this.affEquipements = affEquipements;
    }
    
    
}
