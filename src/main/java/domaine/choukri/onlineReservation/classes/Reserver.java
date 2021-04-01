package domaine.choukri.onlineReservation.classes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reserver implements Serializable {
	@Override
	public String toString() {
		return "Reserver [id=" + id + ", date=" + date + ", nbrPlace=" + nbrPlace + "]";
	}
	@Id @GeneratedValue
	private long id;
	private Date date;
	private int nbrPlace;
	
public Reserver( )  {
 
		
	}
	
	public Reserver(Date date,int nbrPlace) throws Exception {
		
		this.date = date;
		setNbrPlace(nbrPlace);
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		Date dateSysteme = new Date();
		if(dateSysteme.compareTo(date)>0)
		{
			this.date = date;
		}
		else new Exception("la date doit etre superieur a la date du systeme");
		
	}
	public int getNbrPlace() {
		return nbrPlace;
	}
	public void setNbrPlace(int nbrPlace) throws Exception {
		
		if(nbrPlace>0)
		{
			this.nbrPlace = nbrPlace;
		}
		else throw new Exception("le nombre de place doit superieur a 0");
		
	}
	 

}
