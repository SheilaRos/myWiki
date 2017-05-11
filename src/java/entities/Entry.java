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
@Table(name = "entry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entry.findAll", query = "SELECT e FROM Entry e")
    , @NamedQuery(name = "Entry.findById", query = "SELECT e FROM Entry e WHERE e.id = :id")
    , @NamedQuery(name = "Entry.findByLanguage", query = "SELECT e FROM Entry e WHERE e.language = :language")
    , @NamedQuery(name = "Entry.findByTitle", query = "SELECT e FROM Entry e WHERE e.title = :title")})
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "language")
    private String language;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "code")
    private String code;
    @JoinColumn(name = "usu", referencedColumnName = "nameUsu")
    @ManyToOne(optional = false)
    private User usu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entry")
    private Collection<VoteEntry> voteEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntry")
    private Collection<Answer> answerCollection;

    public Entry() {
    }

    public Entry(Integer id) {
        this.id = id;
    }

    public Entry(Integer id, String language, String title, String code) {
        this.id = id;
        this.language = language;
        this.title = title;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUsu() {
        return usu;
    }

    public void setUsu(User usu) {
        this.usu = usu;
    }

    @XmlTransient
    public Collection<VoteEntry> getVoteEntryCollection() {
        return voteEntryCollection;
    }

    public void setVoteEntryCollection(Collection<VoteEntry> voteEntryCollection) {
        this.voteEntryCollection = voteEntryCollection;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
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
        if (!(object instanceof Entry)) {
            return false;
        }
        Entry other = (Entry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entry[ id=" + id + " ]";
    }
    
}
