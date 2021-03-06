package be.helha.aemt.control;

import be.helha.aemt.ejb.UserEJB;
import be.helha.aemt.entities.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserControl implements Serializable
{
    
	private static final long serialVersionUID = 8384353133508951696L;
	
	@EJB
    private UserEJB userEJB;
    private User user = new User();


    public List< User > showUserList()
    {
        return userEJB.getAllUsers();
    }
    
    public User showUser(Integer id) {
    	return userEJB.getSpecificUser(id);
    }

    public void createNewUser()
    {
        try
        {
        	// redirect only if register ok and user not yet registerd
            if ( userEJB.createUser( user.getLogin(), user.getPassword() ) != null ) {
            	ExternalContext ec = FacesContext.getCurrentInstance()
                        .getExternalContext();
                try {
                    ec.redirect(ec.getRequestContextPath()
                            + "/index.xhtml");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
    
    public void addNewUser()
    {
        try
        {
        	// redirect only if register ok and user not yet registerd
            if ( userEJB.createUser( user.getLogin(), user.getPassword() ) != null ) {
            	// reload to admin page
            	user.setLogin(null);
            	goToAdminPage();
            }
            
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
    
    private void goToAdminPage() {
    	ExternalContext ec = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/admin/adminUser.xhtml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public User getUser()
    {
        return user;
    }

    public void setUser( User user )
    {
        this.user = user;
    }
    
    public User deleteUser( User user )
    {
    	User userDeleted = userEJB.delete(user);
        if ( userDeleted != null ) {
        	// reload to admin page
        	goToAdminPage();
        }
        return userDeleted;
    }
    
}
