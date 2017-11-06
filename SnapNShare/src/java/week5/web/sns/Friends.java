package week5.web.sns;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.json.JsonObject;
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
   @Path("/timeline/{username}")
   @Produces(MediaType.APPLICATION_JSON)
   public Response getFriendsPosts(@PathParam("username") String username){
       
       return Response.ok().build();
   }
   
    @POST
    @Path("/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(@PathParam("userID") String user, String body){
        //System.out.println(user);
        //System.out.println(body);
        String friendArray = userBean.setFriend(user,body);
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        String[] names = friendArray.split(",");
        System.out.println(names);
        for(int i=0; i<names.length; i++){
            arrayBuilder.add(names[i]);
        }
            JsonArray io = arrayBuilder.build();
        return Response.status(Response.Status.OK).entity(io).build();
        }

     
}
