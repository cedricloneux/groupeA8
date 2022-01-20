package be.helha.aemt.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Participation;

import java.util.List;



@Stateless
@LocalBean
public class ParticipationDAO extends DAO<Participation> {

    @Override
    public Participation create( Participation inscription )
    {
        if ( inscription == null )
        {
            return null;
        }
        em.persist( inscription );
        return inscription;
    }

    @Override
    public Participation read( Integer id )
    {
        if ( id == null )
        {
            return null;
        }
        Participation inscription = em.find( Participation.class, id );
        if ( inscription != null )
        {
        }
        return inscription;
    }

    @Override
    public Participation update( Participation object1, Participation object2 )
    {
        return super.update( object1, object2 );
    }

    @Override
    public Participation delete( Participation object )
    {
        return super.delete( object );
    }

    @Override
    public List< Participation > findAll()
    {
        String selectQuery = "SELECT i FROM Participation i";
        TypedQuery< Participation > query = em.createQuery( selectQuery, Participation.class );
        return query.getResultList();
    }
    
    public List< Participation > findByUser(int idUser)
    {
        String selectQuery = "SELECT i FROM Participation i WHERE i.idUser = :idUser";
        TypedQuery< Participation > query = em.createQuery( selectQuery, Participation.class );
        query.setParameter( "idUser", idUser);
        return query.getResultList();
    }
    
	
}
