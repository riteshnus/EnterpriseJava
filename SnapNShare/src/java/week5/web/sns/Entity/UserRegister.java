/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.web.sns.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ritesh
 */
@Entity
@Table(name="user")
public class UserRegister implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    
    
    @Id @Column(name="username")
    String username;
    
    @Column(name="friends")
    String friends;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }
    
    
    
}
