package domaine.choukri.onlineReservation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domaine.choukri.onlineReservation.classes.Reservation;
 
import domaine.choukri.onlineReservation.dao.IReservationDao;
@Repository("IReservationDao")
public class ReservationDaoImp implements IReservationDao{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public List<Reservation> getAllReservations() {
		return getCurrentSession().createQuery("from Reservation", Reservation.class).list();
		 
	}

	@Override
	public Reservation save(Reservation r) {
		getCurrentSession().save(r);
		return r;
	}

	@Override
	public Reservation update(Reservation r) {
		getCurrentSession().update(r);
		return r;
	}

	@Override
	public Reservation findReservationById(long id) {
		return getCurrentSession().get(Reservation.class, id);
	}

	@Override
	public Boolean delete(Reservation r) {
		getCurrentSession().delete(r);
		return true;
	}


 

	@Override
	public List<Reservation> getAllReservationsNotBooked(long idApprenant) {
		
		return getCurrentSession().createQuery("from Reservation where utilisateur_id != :idApprenant", Reservation.class).setParameter("idApprenant", idApprenant).list();
		 
	}


	@Override
	public List<Reservation> getAllReservationsBooked(long idApprenant) {
		return getCurrentSession().createQuery("from Reservation where utilisateur_id = :idApprenant", Reservation.class).setParameter("idApprenant", idApprenant).list();
	}

}
