/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Operation;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class OperationDao extends AbstractFacade<Operation> {

    private EntityManager em;

    public OperationDao() {
        super(Operation.class);
        this.em = getEntityManager();
    }
    
    public String findBy(int numero) {
        List<Operation> operations = em.createQuery("select e from operation e where e.numero=" + numero).getResultList();
         return operations.get(1).getNom();
    }
}
