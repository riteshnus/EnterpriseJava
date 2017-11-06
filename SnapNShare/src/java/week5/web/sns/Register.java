
package week5.web.sns;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import week5.web.sns.Entity.User;
import week5.web.sns.beans.UserBean;

@RequestScoped
@Path("register")
public class Register {
    
    @EJB UserBean userBean;
    
    @POST
   @Path("/{username}")
   @Produces(MediaType.TEXT_PLAIN)
   //@Consumes(MediaType.APPLICATION_JSON)
   public String registerUser(@PathParam("username") String username){
       User user = new User();
       user.setUsername(username);
       userBean.createUser(user);
       return ("bi");
   }
}
