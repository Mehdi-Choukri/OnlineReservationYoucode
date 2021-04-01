package domaine.choukri.onlineReservation.service;

import java.util.List;

import domaine.choukri.onlineReservation.classes.Utilisateur;

public interface IUtilisateurService {
	public List<Utilisateur> getAllUsers();
	public Utilisateur save(Utilisateur u);
	public Utilisateur update(Utilisateur u);
	public Utilisateur findUserById(long id);
	public Utilisateur Login(String email,String password);
	public Utilisateur findUserByEmail(String email);
}
