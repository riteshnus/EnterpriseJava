/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5.web.sns.Entity;

import java.io.Serializable;
import java.sql.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author siddharth
 */
@Entity
@Table(name="photos")
public class UserPhoto implements Serializable{
    
    @Id @Column(name="imagename")
    private String imageName;
    
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "postedby")
    private User postedByUser;
    
    @Column(name="comment")
    private String comment;
    
    @Column(name="url")
    private String url;
    
    @Column(name="posttime")
    private Date postTime;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public User getPostedByUser() {
        return postedByUser;
    }

    public void setPostedByUser(User postedByUser) {
        this.postedByUser = postedByUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }
    
    public JsonObject toJson() {

		//Builder
		return (Json.createObjectBuilder()
				.add("imageName", imageName)
				.add("postedBy", postedByUser.getUsername())
				.add("comment", comment)
                                .add("url", url)
                                .add("postTime", postTime.toString())
				.build());
	}
    
}
