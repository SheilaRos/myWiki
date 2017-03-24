/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dam
 */
@Entity
@Table(name = "answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a")
    , @NamedQuery(name = "Answer.findById", query = "SELECT a FROM Answer a WHERE a.id = :id")})
public class Answer implements Serializable {

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
    @ManyToMany(mappedBy = "answerCollection")
    private Collection<User> userCollection;
    @JoinColumn(name = "usu", referencedColumnName = "nameUsu")
    @ManyToOne(optional = false)
    private User usu;
    @JoinColumn(name = "id_entry", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entry idEntry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnswer")
    private Collection<AnswerOfAnswer> answerOfAnswerCollection;

    public Answer() {
    }

    public Answer(Integer id) {
        this.id = id;
    }

    public Answer(Integer id, String textAnswer) {
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

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public User getUsu() {
        return usu;
    }

    public void setUsu(User usu) {
        this.usu = usu;
    }

    public Entry getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(Entry idEntry) {
        this.idEntry = idEntry;
    }

    @XmlTransient
    public Collection<AnswerOfAnswer> getAnswerOfAnswerCollection() {
        return answerOfAnswerCollection;
    }

    public void setAnswerOfAnswerCollection(Collection<AnswerOfAnswer> answerOfAnswerCollection) {
        this.answerOfAnswerCollection = answerOfAnswerCollection;
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
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Answer[ id=" + id + " ]";
    }
    
}
