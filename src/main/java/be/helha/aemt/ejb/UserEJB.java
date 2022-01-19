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

    public User createUser( String login, String password, String role )
    {
        return userDAO.create( new User( login, password, role ) );
    }
    
    public User createUser( String login, String password)
    {
        return userDAO.create( new User( login, password) );
    }
    
}