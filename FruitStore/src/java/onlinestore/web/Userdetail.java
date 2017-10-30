package onlinestore.web;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ritesh
 */
@RequestScoped
@Named
public class Userdetail implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory factory;
    
    @Resource(lookup = "jms/warehouseQueue")
    private Queue warehousequeue;
    
    private String name;
    private String address;
    private int phone;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String checkout(Userdetail userdetail){
        System.out.println(userdetail.name);
        try (JMSContext jmsCtx = factory.createContext()) {
			JMSProducer producer = jmsCtx.createProducer();
			TextMessage txtMsg = jmsCtx.createTextMessage();
			txtMsg.setText(new Date() + ">> ");
			producer.send(warehousequeue, txtMsg);

		} catch (JMSException ex) {
			ex.printStackTrace();
		}
        
		System.out.println("checkout: " + userdetail);
//		FacesContext fc = FacesContext.getCurrentInstance();
//		ExternalContext extCtx = fc.getExternalContext();
//
//		HttpSession sess = (HttpSession)extCtx.getSession(false);
//
//		//HttpServletRequest req = (HttpServletRequest)extCtx.getRequest();
//		//HttpSession sess = req.getSession();
//
//		sess.invalidate();

		return ("thankyou");
    }
    
}
