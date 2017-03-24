/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dam
 */
@Entity
@Table(name = "answerOfAnswer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerOfAnswer.findAll", query = "SELECT a FROM AnswerOfAnswer a")
    , @NamedQuery(name = "AnswerOfAnswer.findById", query = "SELECT a FROM AnswerOfAnswer a WHERE a.id = :id")})
public class AnswerOfAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "text_answer")
    private String textAnswer;
    @JoinColumn(name = "usu", referencedColumnName = "nameUsu")
    @ManyToOne(optional = false)
    private User usu;
    @JoinColumn(name = "id_answer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Answer idAnswer;

    public AnswerOfAnswer() {
    }

    public AnswerOfAnswer(Integer id) {
        this.id = id;
    }

    public AnswerOfAnswer(Integer id, String textAnswer) {
        this.id = id;
        this.textAnswer = textAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public User getUsu() {
        return usu;
    }

    public void setUsu(User usu) {
        this.usu = usu;
    }

    public Answer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Answer idAnswer) {
        this.idAnswer = idAnswer;
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
        if (!(object instanceof AnswerOfAnswer)) {
            return false;
        }
        AnswerOfAnswer other = (AnswerOfAnswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AnswerOfAnswer[ id=" + id + " ]";
    }
    
}
