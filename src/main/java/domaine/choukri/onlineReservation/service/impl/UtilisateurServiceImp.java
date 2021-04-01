package domaine.choukri.onlineReservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domaine.choukri.onlineReservation.classes.Utilisateur;
import domaine.choukri.onlineReservation.dao.IUtilisateurDao;
import domaine.choukri.onlineReservation.service.IUtilisateurService;

@Service("iUtilisateurService")
@Transactional
public class UtilisateurServiceImp implements IUtilisateurService {
	
	@Autowired
	IUtilisateurDao iUtilisateurDao;
	@Transactional
	@Override
	public List<Utilisateur> getAllUsers() {
		return iUtilisateurDao.getAllUsers();
	}
	@Transactional
	@Override
	public Utilisateur save(Utilisateur u) {
		 
		return iUtilisateurDao.save(u);
	}
	@Transactional
	@Override
	public Utilisateur update(Utilisateur u) {
		 
		return iUtilisateurDao.update(u);
	}
	@Transactional
	@Override
	public Utilisateur findUserById(long id) {
 		return iUtilisateurDao.findUserById(id);
	}
	@Transactional
	@Override
	public Utilisateur Login(String email, String password) {
		// TODO Auto-generated method stub
		return iUtilisateurDao.Login(email, password);
	}
	@Transactional
	@Override
	public Utilisateur findUserByEmail(String email) {
		 
		return iUtilisateurDao.findUserByEmail(email);
	}

}
