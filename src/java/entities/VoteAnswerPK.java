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
public class VoteAnswerPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usu")
    private String usu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_answer")
    private int idAnswer;

    public VoteAnswerPK() {
    }

    public VoteAnswerPK(String usu, int idAnswer) {
        this.usu = usu;
        this.idAnswer = idAnswer;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usu != null ? usu.hashCode() : 0);
        hash += (int) idAnswer;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoteAnswerPK)) {
            return false;
        }
        VoteAnswerPK other = (VoteAnswerPK) object;
        if ((this.usu == null && other.usu != null) || (this.usu != null && !this.usu.equals(other.usu))) {
            return false;
        }
        if (this.idAnswer != other.idAnswer) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VoteAnswerPK[ usu=" + usu + ", idAnswer=" + idAnswer + " ]";
    }
    
}
