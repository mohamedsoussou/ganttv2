/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.AbstractFacade;
import entities.Tranche;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class TrancheDao extends AbstractFacade<Tranche> {

    private EntityManager em;

    public TrancheDao() {
        super(Tranche.class);
        this.em = getEntityManager();
    }
}
