package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.ActivityDAO;
import be.helha.aemt.entities.Activity;


@Stateless
@LocalBean
public class ActivityEJB {

	    @EJB
	    private ActivityDAO activityDAO;
	    
	    public ActivityEJB()
	    {
	    }

	    public List< Activity > getAllActivities()
	    {
	        return activityDAO.findAll();
	    }

	    public Activity createActivity( String title, String description, String date, String place, String type )
	    {
	        return activityDAO.create( new Activity( title, description, date, place, type ) );
	    }

	    public Activity getSpecificActivity( int id )
	    {
	        return activityDAO.read( id );
	    }
	    
	    public List< Activity > findActivityByType( String type )
	    {
	    	return activityDAO.findActivityByType(type);
	    }
	  	
	    
}	
