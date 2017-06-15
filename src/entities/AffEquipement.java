/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import util.DateUtil;

/**
 *
 * @author Aimad.JAOUHAR
 */
@Entity
public class AffEquipement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Equipement equipement;
    @ManyToOne(fetch = FetchType.EAGER)
    private Casee casee;
    @ManyToOne
    private Operation operationType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeb;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    
    
    
 public Operation getOperationType() {
        return operationType;
    }

    public void setOperationType(Operation operationType) {
        this.operationType = operationType;
    }
    public String getNumCasee() {
        return new SimpleStringProperty(getCasee() == null ? "" : getCasee().getNumCase() + "").get();
    }

    public String getNomEquipement() {
        return new SimpleStringProperty(getEquipement() == null ? "" : getEquipement().getNom() + "").get();
    }
    
    public String getNomOperation() {
        return new SimpleStringProperty(getEquipement()== null || getEquipement().getOperation()==null ? "" : getEquipement().getOperation().getNom()+ "").get();
    }

    public String getStrDateDeb() {
        return new SimpleStringProperty(getDateDeb() == null ? "" : DateUtil.strDateDefaultPattern(getDateDeb()) + "").get();
    }

    public String getStrDateFin() {
        return new SimpleStringProperty(getDateFin() == null ? "" : DateUtil.strDateDefaultPattern(getDateFin()) + "").get();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Casee getCasee() {
        return casee;
    }

    public void setCasee(Casee casee) {
        this.casee = casee;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AffEquipement)) {
            return false;
        }
        AffEquipement other = (AffEquipement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AffEquipement[ id=" + id + " ]";
    }

}
