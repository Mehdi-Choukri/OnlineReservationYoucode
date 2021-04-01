package domaine.choukri.onlineReservation.classes;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 

@Entity
 
public class Reservation implements Serializable {
	
 
	@Id @GeneratedValue
	private long id;
	 
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Reserver reserver;
	private Boolean etat;
	@ManyToOne(cascade=CascadeType.ALL)
	private Utilisateur utilisateur;
	private int rank;
	private int priorityScore;
	
	
	
	public Reservation() {
		 
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", reserver=" + reserver + ", etat=" + etat + ", utilisateur=" + utilisateur
				+ ", rank=" + rank + ", priorityScore=" + priorityScore + "]";
	}
	public Reservation(Reserver reserver, Boolean etat, Utilisateur utilisateur,int rank, int priorityScore) {
		
		this.reserver = reserver;
		this.etat = etat;
		this.utilisateur = utilisateur;
		this.rank = rank;
		this.priorityScore = priorityScore;
	}
	public Reserver getReserver() {
		return reserver;
	}
	public void setReserver(Reserver reserver) {
		this.reserver = reserver;
	}
	public Boolean getEtat() {
		return etat;
	}
	public void setEtat(Boolean etat) {
		this.etat = etat;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public int getPriorityScore() {
		return priorityScore;
	}
	public void setPriorityScore(int priorityScore) {
		this.priorityScore = priorityScore;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
