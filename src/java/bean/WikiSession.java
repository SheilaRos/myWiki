/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
    
    public User obtenerUser(String nombreUsu){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, nombreUsu);
        em.close();
        return user;
    }
    
    public Collection<Entry> selectLikeCodes(String nombreUsu){
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, nombreUsu);
        Collection<Entry> col = user.getEntryCollection();
        em.close();
        return col;
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
    public Collection<Entry> entry(User user){
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, user.getNameUsu());
        Collection<Follow> follow = follow(u);
        Collection<Entry> entry = new ArrayList<>();
        for(Follow f: follow){
            if(f.getFollowPK().getUsuFollower().equals(u.getName())){
               // Collection <Entry> entry2 = em.find(entityClass, entry)
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
