/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Equipement;
import entities.Operation;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class EquipementDao extends AbstractFacade<Equipement> {

    private EntityManager em;

    public EquipementDao() {
        super(Equipement.class);
        this.em = getEntityManager();
    }
            
    public List<Equipement> findbyType(int numero,int numero2) {
       
         return em.createQuery("select e from equipement e where e.operation_numero =" + numero+ " or e.operation_numero = "+numero2).getResultList();
    }
    public List<Equipement> findbyType(int numero) {
       
         return em.createQuery("select e from equipement e where e.operation_numero =" + numero).getResultList();
    }
}
