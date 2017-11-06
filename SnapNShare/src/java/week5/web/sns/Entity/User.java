package week5.web.sns.Entity;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ritesh
 */
@Entity
@Table(name="user")
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    
    
    @Id @Column(name="username")
    String username;
    
    @Column(name="friends")
    String friends;

    @OneToOne(mappedBy = "postedByUser")
    private UserPhoto userPhoto;
    
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

    public UserPhoto getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(UserPhoto userPhoto) {
        this.userPhoto = userPhoto;
    }
    
    
    
}
