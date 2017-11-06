
package week5.web.sns;

import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import week5.web.sns.Entity.User;
import week5.web.sns.beans.UserBean;

@RequestScoped
@Path("/register")
public class Register {
    
    @EJB UserBean userBean;
    
   @POST
   @Path("/{username}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Response registerUser(@PathParam("username") String username){
       User user = new User();
       user.setUsername(username);
       userBean.createUser(user);
        JsonObject jsonObject = Json.createObjectBuilder().add("username", username).build();
        
       return Response.status(Response.Status.CREATED).entity(jsonObject).build();
   }
}
