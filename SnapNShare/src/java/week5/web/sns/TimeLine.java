
package week5.web.sns;


import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.JsonArray;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import week5.web.sns.Entity.User;

import week5.web.sns.beans.UserBean;



/**
 *
 * @author siddharth
 */
@RequestScoped
@Path("timeline")
public class TimeLine {
    
    @EJB UserBean userBean;
    
   @GET
   @Path("/{username}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getFriendsPosts(@PathParam("username") String username){
       User user = new User();
       user.setUsername(username);
//       User userFromDb = userBean.getUser(user);
//       String friendList = userFromDb.getFriends();
//       System.out.println("user is "+ username);
       
          JsonArray array = userBean.getFriendsPhotos(user);
       return Response.status(Response.Status.OK).entity(array).build();
   }
    
}
