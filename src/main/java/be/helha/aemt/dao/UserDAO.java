package be.helha.aemt.dao;

import be.helha.aemt.entities.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;

@Stateless
@LocalBean
public class UserDAO extends DAO< User >
{
    public User findUtilisateurByLogin( User u )
    {
        if ( u == null || u.getLogin() == null )
        {
            return null;
        }
        String loginQuery = "SELECT u FROM User u WHERE u.login = :login";
        Query query = em.createQuery( loginQuery );
        query.setParameter( "login", u.getLogin() );
        User resultUtilisateur = null;
        try
        {
            resultUtilisateur = ( User ) query.getSingleResult();
        } catch ( NoResultException nre )
        {
            nre.printStackTrace();
        }
        return resultUtilisateur;
    }

    @Override
    public User create( User user )
    {
        if ( findUtilisateurByLogin( user ) != null )
        {
            return null;
        }
        if ( user == null )
        {
            return null;
        }
        if ( user.getLogin() == null )
        {
            return null;
        }
        try
        {
            String passwordBase64 = new String( Base64.getEncoder().encode(
                    MessageDigest.getInstance( "SHA-256" )
                            .digest( user.getPassword().getBytes(
                                    StandardCharsets.UTF_8 ) ) ) );
            user.setPassword( passwordBase64 );
            em.persist( user );
            return  user;
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User read( Integer id )
    {
        if ( id == null )
        {
            return null;
        }
        User user = em.find( User.class, id );
        if ( user != null )
        {
        }
        return user;
    }

    @Override
    public User update( User object1, User object2 )
    {
        return super.update( object1, object2 );
    }

    @Override
    public User delete( User object )
    {
        return super.delete( object );
    }
    
    public User delete( int id )
    {
        User user = read(id);
        return delete(user);
    }

    @Override
    public List< User > findAll()
    {
        String selectQuery = "SELECT u FROM User u";
        TypedQuery< User > query = em.createQuery( selectQuery, User.class );
        return query.getResultList();
    }
}
