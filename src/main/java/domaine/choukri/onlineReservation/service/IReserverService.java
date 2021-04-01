package domaine.choukri.onlineReservation.service;

import java.util.List;

import domaine.choukri.onlineReservation.classes.Reserver;
import domaine.choukri.onlineReservation.classes.Utilisateur;

public interface IReserverService {
	
	public List<Reserver> getAllReservations();
	public Reserver save(Reserver r);
	public Reserver update(Reserver r);
	public Reserver findReservationById(long id);
	public Boolean delete(Reserver r);
	public List<Reserver> getAllReservationsBooked(Utilisateur u);
	public List<Reserver> getAllReservationsNotBooked(Utilisateur u);

}
