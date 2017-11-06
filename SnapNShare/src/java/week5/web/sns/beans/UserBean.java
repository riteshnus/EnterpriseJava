/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.web.sns.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import week5.web.sns.Entity.User;
import week5.web.sns.Entity.UserPhoto;

/**
 *
 * @author siddharth
 */
@Stateless
public class UserBean {
    private static final String FRIENDS_QUERY = "select up from UserPhoto up where up.postedByUser in :friendsList order by up.postTime DESC";
    @PersistenceContext private EntityManager em;
    
    public void createUser(User user){
        em.persist(user);
    }
    
    public User getUser(User user){
       User userFromDb = em.find(User.class, user.getUsername());
       return userFromDb;
    }
    public JsonArray getFriendsPhotos(User user){
     User userFromdb = em.find(User.class, user.getUsername());
        String friends = userFromdb.getFriends();
        StringTokenizer token = new StringTokenizer(friends,",");
        List<String> friendList = new ArrayList<>();
        while (token.hasMoreElements()) {
            friendList.add(token.nextElement().toString().trim());
        }
        TypedQuery<UserPhoto> query = em.createQuery(FRIENDS_QUERY, UserPhoto.class);
        query.setParameter("friendsList", friendList);
        query.setMaxResults(5);
        List<UserPhoto> postList = query.getResultList();
        System.out.println("userPhoto is"+ postList.toString());
        JsonArrayBuilder photoArrayBuilder= Json.createArrayBuilder();
        for(UserPhoto up: postList){
            photoArrayBuilder.add(up.toJson().build());
        }
        JsonArray photoArray = photoArrayBuilder.build();
        return photoArray;   
    }
}
