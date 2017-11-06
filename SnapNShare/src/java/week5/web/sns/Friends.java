package week5.web.sns;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import week5.web.sns.Entity.User;
import week5.web.sns.beans.UserBean;

/**
 *
 * @author Ritesh
 */
@RequestScoped
@Path("/friends")
public class Friends {
    @EJB private UserBean userBean;
    
   @GET
   @Path("/{username}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getFriendsPosts(@PathParam("username") String username){
       
       return Response.ok().build();
   }
   
   
}
