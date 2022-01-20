package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.ActivityEJB;
import be.helha.aemt.entities.Activity;
import be.helha.aemt.entities.User;

@Named
@SessionScoped
public class ActivityControl implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2780961816288987522L;
	@EJB
    private ActivityEJB activityEJB;
    private Activity activity = new Activity();


    public List< Activity > showActivityList()
    {
        return activityEJB.getAllActivities();
    }
    
    public List< Activity > showActivityListMindfullness()
    {
        return activityEJB.findActivityByType("mindfullness");
    }
    
    public List< Activity > showActivityListWorkshop()
    {
        return activityEJB.findActivityByType("workshop");
    }
    

    public void createNewActivity()
    {
        try
        {
            activityEJB.createActivity( activity.getTitle(), activity.getDescription(), activity.getDate() , activity.getPlace(), activity.getType() );
            activity.setTitle(null);
            activity.setDescription(null);
            activity.setDate(null);
            activity.setPlace(null);
            activity.setType(null);
        } catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public Activity getSpecificActivity( int id )
    {
        return activityEJB.getSpecificActivity( id );
    }

    public Activity getActivity()
    {
        return activity;
    }

    public void setActivity( Activity publication )
    {
        this.activity = publication;
    }	
    
    public Activity deleteActivity( Activity activity )
    {
    	Activity elementDeleted = activityEJB.delete(activity);
        return elementDeleted;
    }
	
}
