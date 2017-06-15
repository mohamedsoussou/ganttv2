

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author AIMAD
 */
public class GenerateDB {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ganttPU");
        EntityManager em = emf.createEntityManager();
        em.close();
        System.out.println("generating database .... ");
    }

}
