package onlinestore.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ritesh
 */
@SessionScoped
@Named
public class Userdetail implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory factory;
    
    @Resource(lookup = "jms/warehouseQueue")
    private Queue warehousequeue;
    
    private List<Cart> cartlist = new LinkedList<>();
    
    private String name;
    private String address;
    private Integer phone;
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void add(Cart cart) {
            this.cartlist.add(cart);
    }

    public String checkout(Userdetail userdetail){
        System.out.println(userdetail.name);
        System.out.println(cartlist.size());
        try (JMSContext jmsCtx = factory.createContext()) {
			JMSProducer producer = jmsCtx.createProducer();
			TextMessage txtMsg = jmsCtx.createTextMessage();
			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
                        jsonObjBuilder.add("name", userdetail.getName());
                        jsonObjBuilder.add("address", userdetail.getAddress());
                        jsonObjBuilder.add("comment", userdetail.getComment());
                        jsonObjBuilder.add("phone", (userdetail.getPhone() == null)? 0 : userdetail.getPhone());
                        JsonArrayBuilder ItemJsonArray = Json.createArrayBuilder();
                        
                        cartlist.forEach((cart) -> {
                            JsonObjectBuilder ItemJsonObjBuilder = Json.createObjectBuilder();
                            ItemJsonObjBuilder.add("item", cart.getName());
                            ItemJsonObjBuilder.add("quantity", cart.getQuantity());
                            ItemJsonArray.add(ItemJsonObjBuilder);
                        });
                        
                        jsonObjBuilder.add("cart", ItemJsonArray);
                        JsonObject jsonObj = jsonObjBuilder.build();
                        txtMsg.setText(jsonObj.toString());
                        producer.send(warehousequeue, txtMsg);

		} catch (JMSException ex) {
			ex.printStackTrace();
		}
        
		System.out.println("checkout: " + userdetail);
                FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext extCtx = fc.getExternalContext();

		HttpSession sess = (HttpSession)extCtx.getSession(false);
		sess.invalidate();

		cartlist = new LinkedList<>();

		return ("thankyou");
    }
    
}
