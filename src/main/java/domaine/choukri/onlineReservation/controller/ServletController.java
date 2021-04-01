package domaine.choukri.onlineReservation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domaine.choukri.onlineReservation.classes.Reservation;
import domaine.choukri.onlineReservation.classes.Reserver;
import domaine.choukri.onlineReservation.classes.Utilisateur;
import domaine.choukri.onlineReservation.service.IReservationService;
import domaine.choukri.onlineReservation.service.IReserverService;
import domaine.choukri.onlineReservation.service.IUtilisateurService;
import domaine.choukri.onlineReservation.util.ErreurClass;
import domaine.choukri.onlineReservation.util.MailSender;

@Controller
public class ServletController {
	@Autowired
	IUtilisateurService iUtilisateurService;
	@Autowired
	IReserverService iReserverService;
	@Autowired
	IReservationService iReservationService;

	String msgErreur = "";
	
	Utilisateur userConnecter = new Utilisateur();
	 

	@RequestMapping("/")
	public String home(Model model) {
		 
		return "home";
	}

	@RequestMapping("/home")
	public String home2(Model model) {

		return "home";
	}

	@RequestMapping("/register")
	public String register() {

		return "register";
	}
	@RequestMapping("/addReservation")
	public String addReservation() {

		return "addReservation";
	}

	@RequestMapping("/confirmInscriptionEtudiant")
	public String confirmInscriptionEtudiant(Model model, @RequestParam(name = "idUser") int idUser) {
		
		 
		Utilisateur confirmUser = iUtilisateurService.findUserById(idUser);

		confirmUser.setCheckMail(true);

		iUtilisateurService.update(confirmUser);

		return "confirmInscription";
		}
		 
	 
	
	@RequestMapping("/approuver")
	public String approuverEtudiant(Model model, @RequestParam(name = "id") int idApprenant) {
		
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		Utilisateur confirmApprenant = iUtilisateurService.findUserById(idApprenant);

		confirmApprenant.setEtat(true);

		iUtilisateurService.update(confirmApprenant);

		return allUser( model);
		}
		else
		{
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
	
	}
	
	@RequestMapping("/supprimerReservation")
	public String supprimerReservation(Model model, @RequestParam(name = "id") int idReservation) {
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		Reserver reserve = iReserverService.findReservationById(idReservation);

		 
		iReserverService.delete(reserve);
		return reservations(model);
		}
		else
		{
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
	}
	
	@RequestMapping("/validerReservation")
	public String validerReservation(Model model, @RequestParam(name = "id") int idReservation) throws Exception {
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		 
		Reservation reservation = iReservationService.findReservationById(idReservation);
		
		Reserver reserve = reservation.getReserver();
		
		reserve.setNbrPlace(reserve.getNbrPlace()-1);
		
		iReserverService.update(reserve);
 
		reservation.setEtat(true);

		iReservationService.update(reservation);
		return lesReservations(model);
		}
		else
		{
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
		
	}
	
	@RequestMapping("/refuserReservation")
	public String refuserReservation(Model model, @RequestParam(name = "id") int idReservation) {

		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		Reservation reservation = iReservationService.findReservationById(idReservation);
		
		reservation.setEtat(false);

		iReservationService.update(reservation);
		return lesReservations(model);
		}
		else
		{
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
	}
	
	@RequestMapping("/bookReservation")
	public String bookReservation(Model model, @RequestParam(name = "id") int idReservation) {

		System.out.println(userConnecter);

		/*Required test login admin */
		if (userConnecter.getId()>0  && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		 
		
		Reserver reserve = iReserverService.findReservationById(idReservation);
		
		Utilisateur user = userConnecter;
		
		Reservation reservation = new Reservation(reserve,false,user,0,0);
		
		iReservationService.save(reservation);
		 
		return reservations(model);
		}
		else
		{
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
	}
	
	
	

	
	@RequestMapping("/refuser")
	public String refuserEtudiant(Model model, @RequestParam(name = "id") int idApprenant) {
		
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		Utilisateur confirmApprenant = iUtilisateurService.findUserById(idApprenant);

		confirmApprenant.setEtat(false);

		iUtilisateurService.update(confirmApprenant);

		return allUser( model);
		}
		else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(Model model ) {
		 
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		userConnecter = new Utilisateur();

		return home(model);
		}
		else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}

	}
	
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password,HttpSession session) {
		Utilisateur loggedUser = iUtilisateurService.Login(email, password);

	 
		if ("null".equals(loggedUser)) {

			msgErreur = "<br>L'email ou le mot de passe est incorrect";
		}

		if (loggedUser.getCheckMail() != true) {

			msgErreur += "<br> Veillez consulter votre adresse email avant de s'authentifier";
		}

		if (loggedUser.getEtat() != true) {

			msgErreur += "<br> Vous devrier attendre que l'admin accept votre email pour pouvoir s'authentifier";
		}
		if (msgErreur.isEmpty()) {
			
		 userConnecter = loggedUser;
		 session.setAttribute("logged", loggedUser);
		 
		 System.out.println(userConnecter.toString());
	         
			
			if (loggedUser.getNivDroit() == 0)
				return reservations(model);
			else
				return allUser(model);
		}

		else {

			return erreurUser(model);
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model)

	{

		return "login";
	}

	@RequestMapping(value = "/erreurUser", method = RequestMethod.GET)
	public String erreurUser(Model model) {
		model.addAttribute("msgErreur", msgErreur);
		msgErreur = "";
		return "erreurUser";
	}

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public String allUser(Model model) {
		
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
			List<Utilisateur> listApprenant = iUtilisateurService.getAllUsers();
			model.addAttribute("listApprenant", listApprenant);
			return "allUser";
		} else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}

	}
	
	@RequestMapping(value = "/reservations", method = RequestMethod.GET)
	public String reservations(Model model) {
		
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
			List<Reserver> listReservation = iReserverService.getAllReservationsNotBooked(userConnecter);
			 
			model.addAttribute("listReservation", listReservation);
			return "reservations";
		} else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}

	}
	
	@RequestMapping(value = "/lesReservations", method = RequestMethod.GET)
	public String lesReservations(Model model) {
		
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
			List<Reservation> listReservation = iReservationService.getAllReservations();
			 
			model.addAttribute("listReservation", listReservation);
			
			for (Reservation reservation : listReservation) {
				
				System.out.println(reservation.toString());
			}
			return "lesReservations";
		} else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}

	}
	
	@RequestMapping(value = "/reservationApprenant", method = RequestMethod.GET)
	public String reservationApprenant(Model model) {
		
		/*Required test login admin */
		if (userConnecter.getId()>0  && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
			
			 Utilisateur user = userConnecter;
			List<Reserver> listReservation = iReserverService.getAllReservationsBooked(user);
			
			 
			 
			 
			model.addAttribute("listReservation", listReservation);
			return "reservationApprenant";
		} else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}

	}
	
	
	
	
	@RequestMapping(value = "/addReservation", method = RequestMethod.POST)
	public String addReservationPost(Model model, @RequestParam(name = "dateReservation") String dateReservation,
			@RequestParam(name = "nbrplaces") int nbrPlace) throws Exception {
		/*Required test login admin */
		
		
		/*Required test login admin */
		if (userConnecter.getId()>0 && userConnecter.getNivDroit()>0 && userConnecter.getCheckMail()==true && userConnecter.getEtat()==true) {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    Date currentdate = new Date();
		    try {
				currentdate= sdf.parse(dateReservation);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Reserver reserve = new Reserver(currentdate, nbrPlace);	
		 
		 iReserverService.save(reserve) ;
		 return "addReservation";
		}
		else {
			msgErreur = "Vous devrier vous connectez pour accéder a ce service";
			return erreurUser(model);
		}
		 
				
		
		
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(Model model, @RequestParam(name = "nom") String nom,
			@RequestParam(name = "prenom") String prenom, @RequestParam(name = "email") String email,
			@RequestParam(name = "ville") String ville, @RequestParam(name = "password") String password,
			@RequestParam(name = "cpassword") String cpassword) {
		if (password.equals(cpassword)) {
			Utilisateur user = iUtilisateurService.findUserByEmail(email);
			if (user != null) {
				System.out.println("Utilisateur existe deja");
				msgErreur = "Utilisateur existe deja";

			} else {
				Utilisateur us = new Utilisateur(nom, prenom, email, BCrypt.hashpw(password, BCrypt.gensalt()), 0,
						false, ville, new Date(), false);

				if (iUtilisateurService.save(us) != null) {
					Date currentDate = new Date();

					Boolean test = MailSender.sendMail("Brief.Veterinaire@gmail.com", "thisbriefisgood108", email,
							us.getId(), us.getNom() + " " + us.getPrenom(), currentDate.toString());

					if (test) {
						System.out.println("email sent");
					
					}

				} else {
					System.out.println("Erreur de creation de compte");
					msgErreur = "Erreur de creation de compte";
				}

			}
		} else {
			 
			msgErreur = "confirmation incorrecte";
		}
		if (msgErreur.isEmpty() == true) {
			return "register";
		} else
			return erreurUser(model);

	}

}
