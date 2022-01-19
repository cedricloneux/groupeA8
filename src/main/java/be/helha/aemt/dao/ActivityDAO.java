package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Activity;


@Stateless
@LocalBean
public class ActivityDAO extends DAO <Activity> {
	
	
    public Activity findActivityByTitle( Activity p )
    {
        if ( p == null || p.getTitle() == null )
        {
            return null;
        }
        String selectQuery = "SELECT a FROM Activity a WHERE a.title = :title";
        Query query = em.createQuery( selectQuery );
        query.setParameter( "title", p.getTitle() );
        Activity result = null;
        try
        {
            result = ( Activity ) query.getSingleResult();
        } catch ( NoResultException nre )
        {
            nre.printStackTrace();
        }
        return result;
    }
    
    
    public List< Activity > findActivityByType( String type )
    {
    	
    	String selectQuery = "SELECT a FROM Activity a WHERE a.type = :type";
        TypedQuery< Activity > query = em.createQuery( selectQuery, Activity.class );
        query.setParameter( "type", type);
        return query.getResultList();
    }
    

    @Override
    public Activity create( Activity activity )
    {
    	// prevent two activities with same name to be stored
        if ( findActivityByTitle( activity ) != null )
        {
            return null;
        }
        if ( activity == null )
        {
            return null;
        }
        if ( activity.getTitle() == null )
        {
            return null;
        }
        em.persist( activity );
        return activity;
    }

    @Override
    public Activity read( Integer id )
    {
        if ( id == null )
        {
            return null;
        }
        Activity element = em.find( Activity.class, id );
        if ( element != null )
        {
        }
        return element;
    }

    @Override
    public Activity update( Activity object1, Activity object2 )
    {
        // TODO Auto-generated method stub
        return super.update( object1, object2 );
    }

    @Override
    public Activity delete( Activity object )
    {
        // TODO Auto-generated method stub
        return super.delete( object );
    }

    @Override
    public List< Activity > findAll()
    {
        String selectQuery = "SELECT a FROM Activity a";
        TypedQuery< Activity > query = em.createQuery( selectQuery, Activity.class );
        return query.getResultList();
    }

}
