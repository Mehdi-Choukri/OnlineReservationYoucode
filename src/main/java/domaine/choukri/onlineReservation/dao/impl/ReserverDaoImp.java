package domaine.choukri.onlineReservation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domaine.choukri.onlineReservation.classes.Reservation;
import domaine.choukri.onlineReservation.classes.Reserver;
import domaine.choukri.onlineReservation.classes.Utilisateur;
import domaine.choukri.onlineReservation.dao.IReserverDao;

@Repository("IReserverDao")
public class ReserverDaoImp implements IReserverDao{
	
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Reserver> getAllReservations() {
		
		return getCurrentSession().createQuery("from Reserver where nbrPlace>=0", Reserver.class).list();
		 
	}

	@Override
	public Reserver save(Reserver r) {
		 
		getCurrentSession().save(r);
		return r;
	}

	@Override
	public Reserver update(Reserver r) {
		getCurrentSession().update(r);
		return r;
	}

	@Override
	public Reserver findReservationById(long id) {
		return getCurrentSession().get(Reserver.class, id);
	}

	@Override
	public Boolean delete(Reserver r) {
		getCurrentSession().delete(r);
		return true;
	}

	@Override
	public List<Reserver> getAllReservationsBooked(Utilisateur user) {
		return getCurrentSession().createQuery("from Reserver where nbrPlace > 0 and date > current_date and id  in (select R.id.reserver.id from Reservation R "
                + "where R.id.utilisateur=:user) order by date",Reserver.class).setParameter("user", user).list();	
		}

	@Override
	public List<Reserver> getAllReservationsNotBooked(Utilisateur user) {
		
 		return getCurrentSession().createQuery("from Reserver where nbrPlace > 0 and date > current_date and id not in (select R.id.reserver.id from Reservation R "
                + "where R.id.utilisateur=:user) order by date",Reserver.class).setParameter("user", user).list();
	}

	 

}
