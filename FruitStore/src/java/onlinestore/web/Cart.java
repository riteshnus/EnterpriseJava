package onlinestore.web;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ritesh
 */
@RequestScoped
@Named("cart")
public class Cart implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String name;
    private Integer quantity;
    private String img;

    @Inject private Userdetail userdetail;
    
    public Cart(){}
    
    public Cart(String name, Integer quantity, String img){
        this.name = name;
        this.quantity = quantity;
        this.img = img;
    }
    
    public Cart(String name, Integer quantity){
        this.name = name;
        this.quantity = quantity;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void itemAdded(Cart item){
        System.out.println(String.format("name of fruit %s and quantity %s",item.getName(),item.getQuantity()));
        userdetail.add(item);
    }

}
