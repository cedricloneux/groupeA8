package be.helha.aemt.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1340028851724049240L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String title;
    private String description;
    private String date;
    private String place;
    private String type;
    private String image;
    

    public Activity() {

    }
    
    public Activity(String title, String description, String date, String place, String type) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.place = place;
        this.type = type;
    }
    
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", place=" + place + ", type=" + type + ", image=" + image + "]";
	} 
    
    
}