package domaine.choukri.onlineReservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domaine.choukri.onlineReservation.classes.Reserver;
import domaine.choukri.onlineReservation.classes.Utilisateur;
import domaine.choukri.onlineReservation.dao.IReserverDao;
 
import domaine.choukri.onlineReservation.service.IReserverService;

@Service("iReserverService")
@Transactional
public class ReserverServiceImp implements IReserverService{

	@Autowired
	IReserverDao iReserverDao;
	@Transactional
	@Override
	public List<Reserver> getAllReservations() {
 
		return iReserverDao.getAllReservations();
	}
	@Transactional
	@Override
	public Reserver save(Reserver r) {
	 
		return iReserverDao.save(r);
	}
	@Transactional
	@Override
	public Reserver update(Reserver r) {
 
		return iReserverDao.update(r);
	}
	@Transactional
	@Override
	public Reserver findReservationById(long id) {
	 
		return iReserverDao.findReservationById(id);
	}
	@Transactional
	@Override
	public Boolean delete(Reserver r) {
		 
		return iReserverDao.delete(r);
	}
	@Transactional
	@Override
	public List<Reserver> getAllReservationsBooked(Utilisateur user) {

		return iReserverDao.getAllReservationsBooked(user);
	}
	@Transactional
	@Override
	public List<Reserver> getAllReservationsNotBooked(Utilisateur user) {
		
		return iReserverDao.getAllReservationsNotBooked(user);
	}

}
