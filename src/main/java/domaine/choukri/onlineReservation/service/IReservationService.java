package domaine.choukri.onlineReservation.service;

import java.util.List;

import domaine.choukri.onlineReservation.classes.Reservation;

public interface IReservationService {
	

	public List<Reservation> getAllReservations();
	public List<Reservation> getAllReservationsBooked(long idApprenant);
	public List<Reservation> getAllReservationsNotBooked(long idApprenant);
	public Reservation save(Reservation r);
	public Reservation update(Reservation r);
	public Reservation findReservationById(long id);
	public Boolean delete(Reservation r);

}
