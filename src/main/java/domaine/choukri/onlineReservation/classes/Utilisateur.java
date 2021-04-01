package domaine.choukri.onlineReservation.classes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
 

@Entity
 
public class Utilisateur implements Serializable {
	@Id @GeneratedValue
	private long id;
	private String nom ;
	private String prenom;
	@Email
	private String email;
	private String password;
	
	private Date dateInscription;
	private int nivDroit;
	private Boolean etat;
	private String ville;
	private Boolean checkMail;
	
	public Utilisateur(String nom, String prenom, String email, String password, int nivDroit, Boolean etat ,String ville, Date dateInscription, Boolean checkMail ) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;	
		this.nivDroit = nivDroit;
		this.etat = etat;
		setVille(ville);
		setDateInscription(dateInscription);
		setCheckMail(checkMail);
		
		 
	}
	public Utilisateur()
	{}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
	 
		this.password = password;
	}
	public int getNivDroit() {
		return nivDroit;
	}
	public void setNivDroit(int nivDroit) {
		this.nivDroit = nivDroit;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Boolean getCheckMail() {
		return checkMail;
	}

	public void setCheckMail(Boolean checkMail) {
		this.checkMail = checkMail;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", dateInscription=" + dateInscription + ", nivDroit=" + nivDroit + ", etat=" + etat
				+ ", ville=" + ville + ", checkMail=" + checkMail + "]";
	}
 
}
