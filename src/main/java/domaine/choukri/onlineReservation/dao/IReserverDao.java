package domaine.choukri.onlineReservation.dao;

import java.util.List;

 
import domaine.choukri.onlineReservation.classes.Reserver;
import domaine.choukri.onlineReservation.classes.Utilisateur;

public interface IReserverDao {
	
	public List<Reserver> getAllReservations();
	public Reserver save(Reserver r);
	public Reserver update(Reserver r);
	public Boolean delete(Reserver r);
	public Reserver findReservationById(long id);
	public List<Reserver> getAllReservationsBooked(Utilisateur u);
	public List<Reserver> getAllReservationsNotBooked(Utilisateur u);

}
