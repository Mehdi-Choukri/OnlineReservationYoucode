package domaine.choukri.onlineReservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domaine.choukri.onlineReservation.classes.Reservation;
import domaine.choukri.onlineReservation.dao.IReservationDao;
 
import domaine.choukri.onlineReservation.service.IReservationService;

@Service("iReservationService")
@Transactional
public class ReservationServiceImp implements IReservationService {

	@Autowired
	IReservationDao iReservationDao;
	@Transactional
	
	@Override
	public List<Reservation> getAllReservations() {
		 
		return iReservationDao.getAllReservations();
	}
	@Transactional
	@Override
	public List<Reservation> getAllReservationsBooked(long idApprenant) {
		return iReservationDao.getAllReservationsBooked(idApprenant);
	}
	@Transactional
	@Override
	public List<Reservation> getAllReservationsNotBooked(long idApprenant) {
		return iReservationDao.getAllReservationsNotBooked(idApprenant);
	}
	@Transactional
	@Override
	public Reservation save(Reservation r) {
		 
		return iReservationDao.save(r);
	}
	@Transactional
	@Override
	public Reservation update(Reservation r) {
	 
		return iReservationDao.update(r);
	}
	@Transactional
	@Override
	public Reservation findReservationById(long id) {
		 
		return iReservationDao.findReservationById(id);
	}
	@Transactional
	@Override
	public Boolean delete(Reservation r) {
		 
		return iReservationDao.delete(r);
	}

}
