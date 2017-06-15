/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.AbstractFacade;
import entities.RefStock;
import entities.Stock;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Aimad.JAOUHAR
 */
public class StockDao extends AbstractFacade<Stock> {

    private EntityManager em;

    public int addStock(Stock stock) {
        int code = verifyAddStockErrors(stock);
        if (code > 0) {
            create(stock);
        }
        return code;
    }

    private int verifyAddStockErrors(Stock stock) {
        if (stock == null) {
            return -1;
        }
//        if (stock.getNumero() < 0) {
//            return -2;
//        }
        return 1;
    }

    public List<Stock> findByCritere(Long numero, RefStock refStock, Date dateMin, Date dateMax) {
        String query = "select s Stock s where 1=1 ";

        if (numero != null) {
            query += " and s.numero=" + numero;
        }
        if(refStock != null){
            query += " and s.refStock.numero="+numero;
        }
        return em.createQuery(query).getResultList();
    }

    public StockDao() {
        super(Stock.class);
        this.em = getEntityManager();
    }
}
