package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.ParticipationDAO;
import be.helha.aemt.entities.Participation;



@Stateless
@LocalBean
public class ParticipationEJB {

    @EJB
    private ParticipationDAO participationDAO;

    public ParticipationEJB()
    {
    }

    public List< Participation > getAllParticipations()
    {
        return participationDAO.findAll();
    }

    public Participation createInscription( Integer idUser, Integer idActivity )
    {
        return participationDAO.create( new Participation( idUser, idActivity));
    }

    public Participation getSpecificInscription( Integer id )
    {
        return participationDAO.read( id );
    }	
	
}
