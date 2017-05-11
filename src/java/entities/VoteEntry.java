/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dam
 */
@Entity
@Table(name = "voteEntry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoteEntry.findAll", query = "SELECT v FROM VoteEntry v")
    , @NamedQuery(name = "VoteEntry.findByUsu", query = "SELECT v FROM VoteEntry v WHERE v.voteEntryPK.usu = :usu")
    , @NamedQuery(name = "VoteEntry.findByIdEntry", query = "SELECT v FROM VoteEntry v WHERE v.voteEntryPK.idEntry = :idEntry")
    , @NamedQuery(name = "VoteEntry.findByFecha", query = "SELECT v FROM VoteEntry v WHERE v.fecha = :fecha")})
public class VoteEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VoteEntryPK voteEntryPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "usu", referencedColumnName = "nameUsu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "id_entry", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entry entry;

    public VoteEntry() {
    }

    public VoteEntry(VoteEntryPK voteEntryPK) {
        this.voteEntryPK = voteEntryPK;
    }

    public VoteEntry(String usu, int idEntry) {
        this.voteEntryPK = new VoteEntryPK(usu, idEntry);
    }

    public VoteEntryPK getVoteEntryPK() {
        return voteEntryPK;
    }

    public void setVoteEntryPK(VoteEntryPK voteEntryPK) {
        this.voteEntryPK = voteEntryPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voteEntryPK != null ? voteEntryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoteEntry)) {
            return false;
        }
        VoteEntry other = (VoteEntry) object;
        if ((this.voteEntryPK == null && other.voteEntryPK != null) || (this.voteEntryPK != null && !this.voteEntryPK.equals(other.voteEntryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VoteEntry[ voteEntryPK=" + voteEntryPK + " ]";
    }
    
}
