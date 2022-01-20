package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participation implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5567185485336951217L;
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
	private Integer idUser;
	private Integer idActivity;
	
	public Participation()
	{
		
	}

	public Participation(Integer idUser, Integer idActivity) {
		super();
		this.idUser = idUser;
		this.idActivity = idActivity;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(Integer idActivity) {
		this.idActivity = idActivity;
	}


}
