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
public class FollowPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usu_follow")
    private String usuFollow;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usu_follower")
    private String usuFollower;

    public FollowPK() {
    }

    public FollowPK(String usuFollow, String usuFollower) {
        this.usuFollow = usuFollow;
        this.usuFollower = usuFollower;
    }

    public String getUsuFollow() {
        return usuFollow;
    }

    public void setUsuFollow(String usuFollow) {
        this.usuFollow = usuFollow;
    }

    public String getUsuFollower() {
        return usuFollower;
    }

    public void setUsuFollower(String usuFollower) {
        this.usuFollower = usuFollower;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuFollow != null ? usuFollow.hashCode() : 0);
        hash += (usuFollower != null ? usuFollower.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowPK)) {
            return false;
        }
        FollowPK other = (FollowPK) object;
        if ((this.usuFollow == null && other.usuFollow != null) || (this.usuFollow != null && !this.usuFollow.equals(other.usuFollow))) {
            return false;
        }
        if ((this.usuFollower == null && other.usuFollower != null) || (this.usuFollower != null && !this.usuFollower.equals(other.usuFollower))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.FollowPK[ usuFollow=" + usuFollow + ", usuFollower=" + usuFollower + " ]";
    }
    
}
