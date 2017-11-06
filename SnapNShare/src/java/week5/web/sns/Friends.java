package week5.web.sns;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ritesh
 */
@RequestScoped
@Path("/friends")
public class Friends {
    
    
        @GET
	@Produces(MediaType.TEXT_PLAIN)
	public String get() {
            System.out.println("dff");
            return ("ri");
	}
}
