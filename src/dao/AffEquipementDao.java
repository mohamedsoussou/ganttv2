/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.AffEquipement;
import entities.Casee;
import entities.Equipement;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class AffEquipementDao extends AbstractFacade<AffEquipement>{
    
    private EntityManager em;
    
    public List<AffEquipement> findByEquipement(Equipement equipement){
        return findByCriteres(equipement, null, null, null, null, null);
    }
    
    public List<AffEquipement> findByCriteres(Equipement equipement, Casee casee, Date dateDebMax, Date dateDebMin, Date dateFinMax, Date dateFinMin){
        String query = "select a from AffEquipement a where 1=1 ";
        if(equipement != null){
            query += " and a.equipement.id="+equipement.getId();
        }
        if(casee != null){
            query +=" and a.casee.id="+casee.getId();
        }
        return em.createQuery(query).getResultList();
    }
    
    public List<AffEquipement> findByCriteres(Equipement equipement,Date date){ 
        return em.createQuery("select a from AffEquipement a where (a.datefin <="+date+") and a.equipementid = "+equipement.getOperation().getNumero()).getResultList();
    }
    

    public AffEquipementDao() {
        super(AffEquipement.class);
        this.em = getEntityManager();
    }
    
}
