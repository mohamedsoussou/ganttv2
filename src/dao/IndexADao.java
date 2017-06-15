/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Casee;
import entities.Exploitation;
import entities.IndexA;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class IndexADao extends AbstractFacade<IndexA> {

    private EntityManager em;

    public IndexADao() {
        super(IndexA.class);
        this.em = getEntityManager();
    }

    public int findBy(int operation_numero,long niveau_numero) {
        List<IndexA> indexAs = em.createQuery("select e from indexa e where e.operation_numero=" + operation_numero+" and e.niveau_numero="+niveau_numero ).getResultList();
         return indexAs.get(1).getTempsOp();
    }
}
