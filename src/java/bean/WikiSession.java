/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Answer;
import entities.Entry;
import entities.Follow;
import entities.FollowPK;
import entities.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author dam
 */
@Stateless
public class WikiSession {

    @PersistenceUnit
    EntityManagerFactory emf;
    
    public boolean insertUser(User u) {
        EntityManager em = emf.createEntityManager();
        User exist = em.find(User.class, u.getNameUsu());
        
        boolean ok = false;
        if (exist == null) {
            Query email = em.createNamedQuery("User.findByEmail");
            email.setParameter("email", u.getEmail());
            List<User> listUser = email.getResultList();
            if (listUser.isEmpty()) {
                em.persist(u);
                ok = true;
            } 
        }
        em.close();
        return ok;
    }
       
    public User validarUser(User user){
        EntityManager em = emf.createEntityManager();
        User exist = em.find(User.class, user.getNameUsu());
        if(exist != null){
            if(!exist.getPass().equals(user.getPass())){
                exist = null;
            }
        }
        em.close();
        return exist;
    }
    public boolean modificarUsuario(User u){
       EntityManager em = emf.createEntityManager();
       User usu = em.find(User.class, u.getNameUsu());
       boolean ok = false;
       if(usu != null){
           usu.setBio(u.getBio());
           usu.setEmail(u.getEmail());
           usu.setName(u.getName());
           usu.setLocation(u.getLocation());
           em.persist(usu);
           ok = true;
       }
       em.close();
       return ok;
   }
    public boolean modificaPass(User u){
        EntityManager em = emf.createEntityManager();
       User usu = em.find(User.class, u.getNameUsu());
       boolean ok = false;
       if(usu != null){
           usu.setPass(u.getPass());
           em.persist(usu);
           ok = true;
       }
       em.close();
       return ok;
    }
    public Collection <User> allUsers(){
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("User.findAll").getResultList();
    }
    
    public Collection <Entry> allEntry(){
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Entry.findAll").getResultList();
    }
    
    public Entry selectEntry(int id){
        EntityManager em = emf.createEntityManager();
        Entry entry = em.find(Entry.class, id);
        em.close();
        return entry;
    }
    public Collection <Answer> selectAnswer(int id){
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Select a from Answer where a.id_entry = "+id+"").getResultList();
    }
    public User obtenerUser(String nombreUsu){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, nombreUsu);
        em.close();
        return user;
    }
    
    public Collection<Entry> selectUserCodes(String nombreUsu){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, nombreUsu);
        Collection<Entry> col = user.getEntryCollection();
        em.close();
        return col;
    }
    public Collection<Entry> selectLikeCodes(String nombreUsu){
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("Select e from Entry e where e.id in (Select a.id_entry from (clase likes entry) a where a.usu = '" + nombreUsu + "')").getResultList();
    }
    public Collection<Follow> follow(User user1){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, user1.getNameUsu());
        Collection<Follow> follow = user.getFollowCollection();
        return follow;
    }
    public Collection<Follow> followed(User user1){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, user1.getNameUsu());
        Collection <Follow> followed = new ArrayList<>();
        Collection <Follow> allFollow = em.createNamedQuery("Follow.findAll").getResultList();
        for(Follow f : allFollow){
            if(f.getUser1().equals(user)){
                followed.add(f);
            }
        }
        return followed;
    }
    public Collection<Entry> entryOfFollow(List<Follow> foll){
        EntityManager em = emf.createEntityManager();
        Collection<Entry> entry = new ArrayList<>();
        for(Follow f: foll){
           Collection<Entry> en = selectUserCodes(f.getUser1().getNameUsu());
           for(Entry e : en){
               entry.add(e);
           }
        }  
        return entry;
    }
    public boolean insertCode(Entry e) {
            EntityManager em = emf.createEntityManager();
            em.persist(e);
            em.close();
            return true;
    }
    public Entry selectCode(String nombreUsu){
        EntityManager em = emf.createEntityManager();
        Entry entry = em.find(Entry.class, nombreUsu);        
        em.close();
        return entry;
    }
}
