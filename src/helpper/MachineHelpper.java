package helpper;

import entities.AffEquipement;
import java.util.List;

import javafx.scene.control.TableView;

public class MachineHelpper extends AbstractFxHelper<AffEquipement> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("ID", "id"),
            new AbstractFxHelperItem("Numero case", "numCasee"),
            new AbstractFxHelperItem("Nom equipement", "nomEquipement"),
            new AbstractFxHelperItem("Operation", "nomOperation")
        };
    }

    public MachineHelpper(TableView<AffEquipement> table, List<AffEquipement> list) {
        super(titres, table, list);
    }

    public MachineHelpper(TableView<AffEquipement> table) {
        super(titres, table);
    }

}
