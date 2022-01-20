package be.helha.aemt.ejb;

import be.helha.aemt.dao.UserDAO;
import be.helha.aemt.entities.User;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class UserEJB
{
    @EJB
    private UserDAO userDAO;

    public UserEJB()
    {
    }

    public List< User > getAllUsers()
    {
        return userDAO.findAll();
    }
    
    public User getSpecificUser(int id)
    {
        return userDAO.read(id);
    }

    public User createUser( String login, String password, String role )
    {
        return userDAO.create( new User( login, password, role ) );
    }
    
    public User createUser( String login, String password)
    {
        return userDAO.create( new User( login, password) );
    }
    
    public User delete( int id ) {
    	return userDAO.delete(id);
    }
    
    public User delete( User user ) {
    	return userDAO.delete(user);
    }
    
}