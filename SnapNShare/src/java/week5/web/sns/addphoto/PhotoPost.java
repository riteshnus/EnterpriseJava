/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.web.sns.addphoto;

import java.io.File;
import java.io.InputStream;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import week5.web.sns.Entity.User;
import week5.web.sns.beans.UserBean;

/**
 *
 * @author Ritesh
 */
@RequestScoped
@Path("/timeline")
public class PhotoPost {
    
   @EJB UserBean userBean;
    
  @POST
   @Path("/{username}")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.MULTIPART_FORM_DATA)
   public String uploadFile(InputStream stream){
       System.out.println(stream);
        
      return ("bu");
   }
}
