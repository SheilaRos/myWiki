/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dam
 */
@Embeddable
public class VoteEntryPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usu")
    private String usu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_entry")
    private int idEntry;

    public VoteEntryPK() {
    }

    public VoteEntryPK(String usu, int idEntry) {
        this.usu = usu;
        this.idEntry = idEntry;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public int getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(int idEntry) {
        this.idEntry = idEntry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usu != null ? usu.hashCode() : 0);
        hash += (int) idEntry;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoteEntryPK)) {
            return false;
        }
        VoteEntryPK other = (VoteEntryPK) object;
        if ((this.usu == null && other.usu != null) || (this.usu != null && !this.usu.equals(other.usu))) {
            return false;
        }
        if (this.idEntry != other.idEntry) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VoteEntryPK[ usu=" + usu + ", idEntry=" + idEntry + " ]";
    }
    
}
