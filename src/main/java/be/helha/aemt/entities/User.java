package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String login;
    private String password;
    private String role;

    public User()
    {
    }

    public User( String login, String password, String role )
    {
        this.login = login;
        this.password = password;
        this.role = role;
    }
    
    public User( String login, String password )
    {
    	this(login, password, "user");
    }

    public Integer getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin( String login )
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole( String role )
    {
        this.role = role;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
