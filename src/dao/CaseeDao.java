/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Casee;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class CaseeDao extends AbstractFacade<Casee> {
    
    private EntityManager em;
    
    public CaseeDao() {
        super(Casee.class);
        this.em = getEntityManager();
    }

}
