package onlinestore.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

/**
 *
 * @author Ritesh
 */
@RequestScoped
@Named("control")
public class StoreController {
    
    private List<Cart> items = new LinkedList<>();
    
//    private List<Cart> cartitems = new LinkedList<>();

 

    
    @PostConstruct
	private void init() {
            items.add(new Cart("acorn squash",0,"/Images/acorn_squash.png"));
            items.add(new Cart("Apple",0,"/Images/apple.png"));
            items.add(new Cart("Bell Paper",0,"/Images/bell_pepper.png"));
            items.add(new Cart("Blueberries",0,"/Images/blueberries.png"));
            items.add(new Cart("Brocoli",0,"/Images/broccoli.png"));
            items.add(new Cart("Carrot",0,"/Images/carrot.png"));
            items.add(new Cart("Celery",0,"/Images/celery.png"));
            items.add(new Cart("chili Pepper",0,"/Images/chili_pepper.png"));
            items.add(new Cart("Corn",0,"/Images/corn.png"));
            items.add(new Cart("Egg Plant",0,"/Images/eggplant.png"));
            items.add(new Cart("Harold",0,"/Images/harold.png"));
            items.add(new Cart("Lettuce",0,"/Images/lettuce.png"));
            items.add(new Cart("Onion",0,"/Images/onion.png"));
            items.add(new Cart("Potato",0,"/Images/potato.png"));
            items.add(new Cart("Pumpkin",0,"/Images/pumpkin.png"));
            items.add(new Cart("Radish",0,"/Images/radish.png"));
            items.add(new Cart("Squash",0,"/Images/squash.png"));
            items.add(new Cart("Sugar_snap",0,"/Images/sugar_snap.png"));
            items.add(new Cart("Tomato",0,"/Images/tomato.png"));
            items.add(new Cart("Zucchini",0,"/Images/zucchini.png"));        
        }
        
    public List<Cart> getItems() {
        return items;
    }

    public void setItems(List<Cart> items) {
        this.items = items;
    }
    
    
    
    public String checkout(){
        return ("checkout");
    }
    

}
