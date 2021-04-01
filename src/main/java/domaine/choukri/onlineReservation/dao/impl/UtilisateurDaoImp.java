package domaine.choukri.onlineReservation.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domaine.choukri.onlineReservation.classes.Utilisateur;
import domaine.choukri.onlineReservation.dao.IUtilisateurDao;

@Repository("iUtilisateurDao")
public class UtilisateurDaoImp implements IUtilisateurDao {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Utilisateur> getAllUsers() {
		return getCurrentSession().createQuery("from Utilisateur where nivDroit=0", Utilisateur.class).list();
	}

	@Override
	public Utilisateur save(Utilisateur u) {

		getCurrentSession().save(u);
		return u;
	}

	@Override
	public Utilisateur update(Utilisateur u) {
		getCurrentSession().update(u);
		return u;
	}

	@Override
	public Utilisateur findUserById(long id) {
		return getCurrentSession().get(Utilisateur.class, id);
	}

	@Override
	public Utilisateur Login(String email, String password) {

		Utilisateur user = findUserByEmail(email);
		if (user == null) {
			user = new Utilisateur();
		}
		if (user != null) {
			if (!BCrypt.checkpw(password, user.getPassword())) {
				user = new Utilisateur();
			}
		}
		return user;
	}

	@Override
	public Utilisateur findUserByEmail(String email) {

		 Utilisateur user = getCurrentSession().createQuery("from Utilisateur where email =:email", Utilisateur.class)
				.setParameter("email", email).uniqueResult();
		 return user;

	}

}
