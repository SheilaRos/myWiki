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
@Table(name = "follow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Follow.findAll", query = "SELECT f FROM Follow f")
    , @NamedQuery(name = "Follow.findByUsuFollow", query = "SELECT f FROM Follow f WHERE f.followPK.usuFollow = :usuFollow")
    , @NamedQuery(name = "Follow.findByUsuFollower", query = "SELECT f FROM Follow f WHERE f.followPK.usuFollower = :usuFollower")
    , @NamedQuery(name = "Follow.findByFecha", query = "SELECT f FROM Follow f WHERE f.fecha = :fecha")})
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FollowPK followPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "usu_follow", referencedColumnName = "nameUsu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "usu_follower", referencedColumnName = "nameUsu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user1;

    public Follow() {
    }

    public Follow(FollowPK followPK) {
        this.followPK = followPK;
    }

    public Follow(String usuFollow, String usuFollower) {
        this.followPK = new FollowPK(usuFollow, usuFollower);
    }

    public FollowPK getFollowPK() {
        return followPK;
    }

    public void setFollowPK(FollowPK followPK) {
        this.followPK = followPK;
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

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followPK != null ? followPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Follow)) {
            return false;
        }
        Follow other = (Follow) object;
        if ((this.followPK == null && other.followPK != null) || (this.followPK != null && !this.followPK.equals(other.followPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Follow[ followPK=" + followPK + " ]";
    }
    
}
