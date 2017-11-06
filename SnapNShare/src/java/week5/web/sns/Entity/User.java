package week5.web.sns.Entity;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
public class User implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    
    
    
    @Id @Column(name="username")
    String username;
    
    @Column(name="friends")
    String friends;
}
