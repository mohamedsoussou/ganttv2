/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Niveau;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class NiveauDao extends AbstractFacade<Niveau> {

    private EntityManager em;

    public NiveauDao() {
        super(Niveau.class);
        this.em = getEntityManager();
    }
}
