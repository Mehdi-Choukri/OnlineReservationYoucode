package domaine.choukri.onlineReservation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domaine.choukri.onlineReservation.classes.Utilisateur;
import domaine.choukri.onlineReservation.service.IUtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/dispatcher-config.xml"})
public class UtilisateurTest {
	
	@Autowired
	private IUtilisateurService iUtilisateurService;
	
 
	@Test
	public void testfind()
	{
		Utilisateur user  = iUtilisateurService.findUserByEmail("Admin@gmail.com");
		assertNotNull(user);
		//assertEquals(2, user.getNivDroit());
		
		
		
	}
	
	@Test
	public void testLogin()
	{
		Utilisateur user  =   iUtilisateurService.Login("Admin@gmail.com", "1234");
		assertEquals("Hamid", user.getNom());
	}
	
	@Test
	public void testfindById()
	{
		Utilisateur user  = iUtilisateurService.findUserById(100);
		assertNotNull(user);
		//assertEquals(2, user.getNivDroit());
		
		
		
	}
	
	 
}
