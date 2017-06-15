/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.RefStock;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class RefStockDao extends AbstractFacade<RefStock> {

    private EntityManager em;

    public RefStockDao() {
        super(RefStock.class);
        this.em = getEntityManager();
    }
}
