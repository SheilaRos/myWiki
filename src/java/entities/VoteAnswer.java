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
@Table(name = "voteAnswer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoteAnswer.findAll", query = "SELECT v FROM VoteAnswer v")
    , @NamedQuery(name = "VoteAnswer.findByUsu", query = "SELECT v FROM VoteAnswer v WHERE v.voteAnswerPK.usu = :usu")
    , @NamedQuery(name = "VoteAnswer.findByIdAnswer", query = "SELECT v FROM VoteAnswer v WHERE v.voteAnswerPK.idAnswer = :idAnswer")
    , @NamedQuery(name = "VoteAnswer.findByFecha", query = "SELECT v FROM VoteAnswer v WHERE v.fecha = :fecha")})
public class VoteAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VoteAnswerPK voteAnswerPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "usu", referencedColumnName = "nameUsu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "id_answer", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Answer answer;

    public VoteAnswer() {
    }

    public VoteAnswer(VoteAnswerPK voteAnswerPK) {
        this.voteAnswerPK = voteAnswerPK;
    }

    public VoteAnswer(String usu, int idAnswer) {
        this.voteAnswerPK = new VoteAnswerPK(usu, idAnswer);
    }

    public VoteAnswerPK getVoteAnswerPK() {
        return voteAnswerPK;
    }

    public void setVoteAnswerPK(VoteAnswerPK voteAnswerPK) {
        this.voteAnswerPK = voteAnswerPK;
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voteAnswerPK != null ? voteAnswerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VoteAnswer)) {
            return false;
        }
        VoteAnswer other = (VoteAnswer) object;
        if ((this.voteAnswerPK == null && other.voteAnswerPK != null) || (this.voteAnswerPK != null && !this.voteAnswerPK.equals(other.voteAnswerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VoteAnswer[ voteAnswerPK=" + voteAnswerPK + " ]";
    }
    
}
