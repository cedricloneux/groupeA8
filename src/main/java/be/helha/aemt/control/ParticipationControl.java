package be.helha.aemt.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

import be.helha.aemt.ejb.ParticipationEJB;
import be.helha.aemt.entities.Participation;

@Named
@SessionScoped
public class ParticipationControl implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7534016929161859816L;
	@EJB
    private ParticipationEJB participationEJB;
    private Participation participation = new Participation();

    public String showListPage()
    {
        return "/users/listeInscriptions.xhtml?faces-redirect=true";
    }

    public String showAddPage()
    {
        return "/admin/ajoutInscription.xhtml?faces-redirect=true";
    }

    public List< Participation > showInscriptionList()
    {
        return participationEJB.getAllParticipations();
    }

    @PostConstruct
    public void createNewInscription()
    {
        try
        {
        	participationEJB.createInscription(participation.getIdUser(), participation.getIdActivity() );
        	participation.setIdUser(null);
        	participation.setIdActivity(null);
        } catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

    public Participation getSpecificInscription( Integer id )
    {
        return participationEJB.getSpecificInscription( id );
    }

    public Participation getParticipation()
    {
        return participation;
    }

    public void setInscription( Participation inscription )
    {
        this.participation = inscription;
    }
    
    	
}
