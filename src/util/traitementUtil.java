/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.AffEquipementDao;
import dao.EquipementDao;
import dao.ExploitationDao;
import dao.IndexADao;
import dao.OperationDao;
import entities.AffEquipement;
import entities.Equipement;
import entities.Exploitation;
import entities.Niveau;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.gantt.Task;

/**
 *
 * @author HP
 */
public class traitementUtil {

    private IntervalCategoryDataset CreationDataset(Input input) throws ParseException, SQLException {

        IndexADao indexADao = new IndexADao();
        TaskSeriesCollection collection = new TaskSeriesCollection();
        Calendar calendar = Calendar.getInstance();
        OperationDao operationDao = new OperationDao();

        List<Exploitation> exploitations;
        ExploitationDao exploitationDao = new ExploitationDao();
        exploitations = exploitationDao.findAll();

        Date date1, date2 = null;

        for (double i = 0; i < 10; i = +0.01) {
            List<Exploitation> exps;
            exps = exploitationDao.findbyIndice(i);

            if (exps.isEmpty() == false) {
                for (int j = 0; j < exps.size(); j++) {

                    Exploitation exploitation = exps.get(j);
                    if (exploitation.getCasee().getNiveauPre().getNumero() < exploitation.getNiveauBut().getNumero()) {

                        Niveau niveau = exploitation.getCasee().getNiveauPre();
                        date1 = exploitation.getDateDebut();
                        TaskSeries series = new TaskSeries("C" + exploitation.getCasee().getNumCase() + "N" + niveau.getNumero());

                        if (niveau.getType() == 0) {

                            for (int k = 1; k < 6; k++) {
                                if (k != 3) {
                                    date1 = effectuerOp(k, date1);
                                }
                                calendar.setTime(date1);
                                calendar.add(Calendar.HOUR, +indexADao.findBy(k, niveau.getNumero()));
                                date2 = calendar.getTime();
                                series.add(new Task(operationDao.findBy(k), date1, date2));
                            }

                            exploitation.getCasee().getNiveauPre().setNumero(exploitation.getCasee().getNiveauPre().getNumero() + 1);
                            exploitation.setDateDebut(date2);

                        } else if (niveau.getType() == 1) {
                            for (int k = 6; k < 8; k++) {

                                date1 = effectuerOp(k, date1);
                                calendar.setTime(date1);
                                calendar.add(Calendar.HOUR, +indexADao.findBy(k, niveau.getNumero()));
                                date2 = calendar.getTime();
                                series.add(new Task(operationDao.findBy(k), date1, date2));
                            }
                            exploitation.getCasee().getNiveauPre().setNumero(exploitation.getCasee().getNiveauPre().getNumero() + 1);
                            exploitation.setDateDebut(date2);
                        }

                    }

                }
            }

        }

        return collection;
    }

    private Date effectuerOp(int numOperation, Date date) {
        AffEquipementDao affEquipementDao = new AffEquipementDao();
        EquipementDao equipementDao = new EquipementDao();
        List<AffEquipement> affEquipements;
        List<Equipement> equipements;

        switch (numOperation) {
            case 1:
                equipements = equipementDao.findbyType(1, 4);
                return trouverDateMin(equipements, date);
            case 2:
                equipements = equipementDao.findbyType(2);
                return trouverDateMin(equipements, date);
            case 4:
                equipements = equipementDao.findbyType(1, 4);
                return trouverDateMin(equipements, date);
            case 5:
                equipements = equipementDao.findbyType(3);
                return trouverDateMin(equipements, date);
            case 6:
                equipements = equipementDao.findbyType(4);
                return trouverDateMin(equipements, date);
            case 7:
                equipements = equipementDao.findbyType(5);
                return trouverDateMin(equipements, date);

        }
        return null;
    }

    private Date trouverDateMin(List<Equipement> equipements, Date date) { // trouver la date minimale pour laquelle les equipements sont diponibles

        AffEquipementDao affEquipementDao = new AffEquipementDao(); //liste des affectations equipements apres la date date pour les equipements equipements

        List<AffEquipement> affEquipements = affEquipementDao.findByCriteres(equipements.get(0), date);

        for (int j = 1; j < equipements.size(); j++) {
            affEquipements.addAll(affEquipementDao.findByCriteres(equipements.get(j), date));
        }

        for (int j = 1; j < equipements.size(); j++) {
            if (equipements.get(j).getAffEquipement() == null) {
                return date;
            }
        }

        Calendar calendar = Calendar.getInstance();
        Date dateMin = affEquipements.get(0).getDateFin();

        for (int j = 1; j < affEquipements.size(); j++) {
            if (date.after(affEquipements.get(j).getDateDeb())) {
                if (dateMin.after(affEquipements.get(j).getDateFin())) {
                    calendar.setTime(affEquipements.get(j).getDateFin());
                    dateMin = calendar.getTime();
                }
            }
        }

        return dateMin;
    }

}
