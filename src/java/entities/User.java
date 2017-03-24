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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findByNameUsu", query = "SELECT u FROM User u WHERE u.nameUsu = :nameUsu")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByLocation", query = "SELECT u FROM User u WHERE u.location = :location")
    , @NamedQuery(name = "User.findByPass", query = "SELECT u FROM User u WHERE u.pass = :pass")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 80)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nameUsu")
    private String nameUsu;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "location")
    private String location;
    @Lob
    @Size(max = 65535)
    @Column(name = "bio")
    private String bio;
    @Lob
    @Column(name = "profilePicture")
    private byte[] profilePicture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pass")
    private String pass;
    @JoinTable(name = "voteEntry", joinColumns = {
        @JoinColumn(name = "usu", referencedColumnName = "nameUsu")}, inverseJoinColumns = {
        @JoinColumn(name = "id_entry", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Entry> entryCollection;
    @JoinTable(name = "voteAnswer", joinColumns = {
        @JoinColumn(name = "usu", referencedColumnName = "nameUsu")}, inverseJoinColumns = {
        @JoinColumn(name = "id_answer", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Answer> answerCollection;
    @JoinTable(name = "follow", joinColumns = {
        @JoinColumn(name = "usu_follow", referencedColumnName = "nameUsu")}, inverseJoinColumns = {
        @JoinColumn(name = "usu_follower", referencedColumnName = "nameUsu")})
    @ManyToMany
    private Collection<User> userCollection;
    @ManyToMany(mappedBy = "userCollection")
    private Collection<User> userCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usu")
    private Collection<Entry> entryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usu")
    private Collection<Answer> answerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usu")
    private Collection<AnswerOfAnswer> answerOfAnswerCollection;

    public User() {
    }

    public User(String nameUsu) {
        this.nameUsu = nameUsu;
    }

    public User(String nameUsu, String email, String pass) {
        this.nameUsu = nameUsu;
        this.email = email;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameUsu() {
        return nameUsu;
    }

    public void setNameUsu(String nameUsu) {
        this.nameUsu = nameUsu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public Collection<Entry> getEntryCollection() {
        return entryCollection;
    }

    public void setEntryCollection(Collection<Entry> entryCollection) {
        this.entryCollection = entryCollection;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<User> getUserCollection1() {
        return userCollection1;
    }

    public void setUserCollection1(Collection<User> userCollection1) {
        this.userCollection1 = userCollection1;
    }

    @XmlTransient
    public Collection<Entry> getEntryCollection1() {
        return entryCollection1;
    }

    public void setEntryCollection1(Collection<Entry> entryCollection1) {
        this.entryCollection1 = entryCollection1;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection1() {
        return answerCollection1;
    }

    public void setAnswerCollection1(Collection<Answer> answerCollection1) {
        this.answerCollection1 = answerCollection1;
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
        hash += (nameUsu != null ? nameUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.nameUsu == null && other.nameUsu != null) || (this.nameUsu != null && !this.nameUsu.equals(other.nameUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.User[ nameUsu=" + nameUsu + " ]";
    }
    
}
