/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.AffEquipement;
import entities.Casee;
import entities.Equipement;
import entities.Exploitation;
import entities.Niveau;
import entities.Stock;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

/**
 *
 * @author Administrateur
 */
public class OptiUtil {

//    public static Object[] getSol(List<Exploitation> exploitations) {
//
//        List<Task> equipementTasks = new ArrayList<>();
//        List<Task> caseeTasks = new ArrayList<>();
//
//        return new Object[]{equipementTasks, caseeTasks};
//    }
//
//    private IntervalCategoryDataset CreationDataset(Input input) throws ParseException, SQLException {
//
//        List<Casee> casees = input.getCasees();
//        List<Equipement> equipements = input.getEquipements();
//        List<AffEquipement> afEquipements = input.getAffEquipements();
//        List<Stock> stocks = input.getStocks();
//                
//
//        Vector vector_stock = Importer.Stock();
//
//        List opt1 = equipements.subList(0, 5);
//        List opt4 = equipements.subList(5, 14);
//        List opt2 = equipements.subList(14, 18);
//        List opt3 = equipements.subList(18, 32);
//        List opt5 = equipements.subList(32, 34); // diviser les equipements selon les operations leurs roles 
//
//        Calendar calendar = Calendar.getInstance();
//        Date date = new Date(), date1 = new Date();
//        date = calendar.getTime();   // date = date acuelle 
//
//        
//        TaskSeriesCollection collection = new TaskSeriesCollection();
//
//        int i = 0, j = 0, k = 0;
//        int num_case, casep = 0;
//        Long num_stock;
//        String nom_op = new String();
//        Long temps_op;
//        int num_op;
//        BigDecimal inc = new BigDecimal("0.01");
//        BigDecimal x = BigDecimal.ZERO;
//        float indice_priorite1;
//        BigDecimal indice_priorite;
//        Date date_deb;
//
//        TaskSeries[] s = new TaskSeries[1000];
//
//        while (i < casees.size() && !casees.isEmpty()) {
//
//            Casee data = casees.get(i);
//
//            num_case = data.getNumCase();
//            date_deb = data.getExploitation().getDateDebut();
//            nom_op = data.getIndexation().getOperation().getNom();
//            temps_op = data.getIndexation().getTempsOp();
//            num_op = data.getIndexation().get;
//            indice_priorite1 = data.getExploitation().getIndicePriorite();
//            indice_priorite = new BigDecimal(Float.toString(indice_priorite1));
//            num_stock = data.getNiveauPre().getRefStock().getNumero();
//            
//
//            if (k == 0) {
//                s[0] = new TaskSeries("case " + num_case + "," + num_stock);
//                casep = num_case;
//                k = 1;
//            }
//
//            if (x.compareTo(indice_priorite) == 0) {
//
//                switch (nom_op) {
//
//                    case "Chargement":
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//
//                        while (verification(afEquipements, opt5, num_case, date, date1, ex[5]) == null) {
//
//                            date = disponibilite(afEquipements, opt5, date);
//                            calendar.setTime(date);
//                            calendar.add(Calendar.HOUR, +temps_op);
//                            date1 = calendar.getTime();
//                        }
//                        s[j].add(new Task("Chargement", date, date1));
//                        collection.add(s[j]);
//                        break;
//
//                    case "Gerbage":
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//
//                        while (verification(n_vector_eq, opt4, num_case, date, date1, ex[4]) == null) {
//                            if (verification(n_vector_eq, opt5, num_case, date, date1, ex[5]) == null) {
//                                while (verification(n_vector_eq, opt4, num_case, date, date1, ex[4]) == null) {
//                                    date = disponibilite(afEquipements, opt4, date);
//                                    calendar.setTime(date);
//                                    calendar.add(Calendar.HOUR, +temps_op.intValue());
//                                    date1 = calendar.getTime();
//                                }
//                            }
//                            break;
//                        }
//                        s[j].add(new Task("Gerbage", date, date1));
//
//                        break;
//                    case "Decapage":
//
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//
//                        while (verification(n_vector_eq, opt3, num_case, date, date1, ex[3]) == null) {
//
//                            date = disponibilite(afEquipements, opt3, date);
//                            calendar.setTime(date);
//                            calendar.add(Calendar.HOUR, +temps_op.intValue());
//                            date1 = calendar.getTime();
//                        }
//
//                        s[j].add(new Task("Decapage", date, date1));
//
//                        break;
//                    case "Amenagement/Decapage":
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//
//                        while (verification(afEquipements, opt1, num_case, date, date1, ex[1]) == null) {
//                            if (verification(afEquipements, opt4, num_case, date, date1, ex[4]) == null) {
//                                while (verification(afEquipements, opt1, num_case, date, date1, ex[1]) == null) {
//                                    date = disponibilite(afEquipements, opt1, date);
//                                    calendar.setTime(date);
//                                    calendar.add(Calendar.HOUR, +temps_op.intValue());
//                                    date1 = calendar.getTime();
//                                }
//                            }
//                            break;
//                        }
//
//                        s[j].add(new Task("Amenagement/Decapage", date, date1));
//
//                        break;
//                    case "Sautage":
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//                        s[j].add(new Task("Sautage", date, date1));
//
//                        break;
//                    case "Foration":
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//
//                        while (verification(n_vector_eq, opt2, num_case, date, date1, ex[2]) == null) {
//
//                            date = disponibilite(afEquipements, opt2, date);
//                            calendar.setTime(date);
//                            calendar.add(Calendar.HOUR, +temps_op.intValue());
//                            date1 = calendar.getTime();
//                        }
//
//                        s[j].add(new Task("Foration", date, date1));
//                        break;
//
//                    case "Amenagement/foration":
//                        calendar.setTime(date);
//                        calendar.add(Calendar.HOUR, +temps_op.intValue());
//                        date1 = calendar.getTime();
//
//                        while (verification(afEquipements, opt1, num_case, date, date1, ex[1]) == null) {
//                            if (verification(afEquipements, opt4, num_case, date, date1, ex[4]) == null) {
//                                while (verification(n_vector_eq, opt1, num_case, date, date1, ex[1]) == null) {
//                                    date = disponibilite(afEquipements, opt1, date);
//                                    calendar.setTime(date);
//                                    calendar.add(Calendar.HOUR, +temps_op.intValue());
//                                    date1 = calendar.getTime();
//                                }
//                            }
//
//                            break;
//                        }
//
//                        s[j].add(new Task("Amenagement/foration", date, date1));
//
//                        break;
//                }
//
//                i++;
//                calendar.setTime(date1);
//                date = calendar.getTime();
//
//                if (nom_op.contains("Chargement")) {
//                    j++;
//                    if (i < casees.size()) {
//                        data = casees.get(i + 1);
//                        num_case = data.getNumCase();
//                        num_stock = data.getNiveauPre().getRefStock().getNumero();
//                    }
//                    s[j] = new TaskSeries(("case " + num_case + "," + num_stock));
//                    if (verification_stock(vector_stock, date1, num_stock.intValue()) == true) {
//                        Vector vp = new Vector();
//                        vp.add(num_stock);
//                        vp.add(date1);
//                        vp.add(-1);
//                        vector_stock.add(vp);
//                    }
//                    k++;
//
//                }//            if(casep != num_case)
////            {
////                calendar = Calendar.getInstance();
////                date.setTime(date_deb.getTime());
////                casep = num_case;
////          }
//
//            } else if (x.compareTo(indice_priorite) != 0) {
//                calendar = Calendar.getInstance();
//                date.setTime(date_deb.getTime());
//                x = x.add(inc);
//            }
//        }
//        
//        
////        Exporter.equipement(afEquipements);
////        Exporter.stock(vector_stock);
//
//        return collection;
//    }
//
//    private static Date disponibilite(List<AffEquipement> equipements, List op, Date date) {
//
//        AffEquipement vp;
//        Vector opp;
//        Date date_min = date(0, 0, 31, 5, 2016);
//
//        for (int i = 0; i < op.size(); i++) {
//            opp = (Vector) op.get(i);
//            String nom_eq = (String) opp.elementAt(1);
//            for (int j = 0; j < equipements.size(); j++) {
//
//                vp = equipements.get(j);
//                if (nom_eq.contains(vp.getNom())) {
//                    if (date_min.after((Date) vp.elementAt(5)) || date_min.before(date)) {
//                        date_min = (Date) vp.elementAt(5);
//                    }
//                }
//            }
//        }
//
//        return date_min;
//    }
//
//    private static Date date(int minute, int heure, int jour, int mois, int annee) {
//        final Calendar calendar = Calendar.getInstance(Locale.FRANCE);
//        calendar.set(annee, mois, jour, heure, minute);
//        final Date result = calendar.getTime();
//        return result;
//    }
//
//    boolean verification_stock(List<Stock> stocks, Date date, int num_stock) {
//
//        Stock vp;
//        for (int i = 0; i < stocks.size(); i++) {
//            vp =  stocks.get(i);
//            Long num_stock1 =  vp.getRefStock().getNumero();
//            Date date1 = vp.getDatee();
//            float aj_pr =  vp.getAjPr();
//            if (date1.equals(date) == true && num_stock1 == num_stock) {
//                return false;
//            } else if (aj_pr != -1) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    Vector verification(Vector vector, List op, int num_case, Date date_deb, Date date_fin, int z) {
//
//        Vector vp, opp = new Vector(), nvp = new Vector();
//        nvp.setSize(6);
//
//        for (int i = 0; i < op.size(); i++) {
//            opp = (Vector) op.get(i);
//            String nom_eq = (String) opp.elementAt(1);
//            int op_aff = (int) opp.elementAt(2);
//            for (int j = 0; j < vector.size(); j++) {
//                // Lire le tableau
//                vp = (Vector) vector.elementAt(j);
//                String nom_eq_v = (String) vp.elementAt(1);
//                Date date_deb_v = (Date) vp.elementAt(4);
//                Date date_fin_v = (Date) vp.elementAt(5);
//                if (nom_eq.contains(nom_eq_v)) {
//                    if ((date_deb.equals(date_deb_v)) && (date_fin.equals(date_fin_v))) //
//                    {
//                        return vector;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < op.size(); i++) {
//            opp = (Vector) op.get(i);
//            String nom_eq = (String) opp.elementAt(1);
//            int op_aff = (int) opp.elementAt(2);
//
//            if (vector.isEmpty()) {
//                vector.setSize(1);
//                opp = (Vector) op.get(1);
//                nvp.set(1, opp.get(1));
//                nvp.set(2, opp.get(2));
//                nvp.set(3, num_case);
//                nvp.set(4, date_deb);
//                nvp.set(5, date_fin);
//                vector.setElementAt(nvp, 0);
//
//                return vector;
//            }
//
//            for (int j = 0; j < vector.size(); j++) {
//                // Lire le tableau
//                vp = (Vector) vector.elementAt(j);
//                String nom_eq_v = (String) vp.elementAt(1);
//                if (z <= op.size()) {
//                    if (nom_eq.contains(nom_eq_v)) {
//                        z++;
//                    }
//                }
//            }
//        }
//        if (z == 0) {
//            opp = (Vector) op.get(1);
//            nvp.set(1, opp.get(1));
//            nvp.set(2, opp.get(2));
//            nvp.set(3, num_case);
//            nvp.set(4, date_deb);
//            nvp.set(5, date_fin);
//            vector.add(nvp);
//            return vector;
//        }
//
//        if (z <= op.size()) {
//            opp = (Vector) op.get(z - 1);
//
//            nvp.set(1, (String) opp.elementAt(1));
//            nvp.set(2, (int) opp.elementAt(2));
//            nvp.set(3, num_case);
//            nvp.set(4, date_deb);
//            nvp.set(5, date_fin);
//            vector.add(nvp);
//            return vector;
//        }
//
//        for (int i = 0; i < op.size(); i++) {
//            opp = (Vector) op.get(i);
//            String nom_eq = (String) opp.elementAt(1);
//            int op_aff = (int) opp.elementAt(2);
//
//            for (int j = 0; j < vector.size(); j++) {
//                // Lire le tableau
//                vp = (Vector) vector.elementAt(j);
//                String nom_eq_v = (String) vp.elementAt(1);
//                Date date_deb_v = (Date) vp.elementAt(4);
//                Date date_fin_v = (Date) vp.elementAt(5);
//                if (nom_eq.contains(nom_eq_v)) {
//
//                    if ((date_deb.after(date_fin_v)) || (date_fin.before(date_deb_v))) {
//
//                        nvp.set(1, nom_eq);
//                        nvp.set(2, op_aff);
//                        nvp.set(3, num_case);
//                        nvp.set(4, date_deb);
//                        nvp.set(5, date_fin);
//                        vector.add(nvp);
//                        return vector;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
}
