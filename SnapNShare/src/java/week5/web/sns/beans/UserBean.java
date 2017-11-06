/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.web.sns.beans;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import week5.web.sns.Entity.User;

/**
 *
 * @author siddharth
 */
@Stateless
public class UserBean {
    
    @PersistenceContext private EntityManager em;
    
    public void createUser(User user){
        em.persist(user);
    }
    
    public JsonObject getFriendsPhotos(User user){
     return null;   
    }
}
