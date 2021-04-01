package domaine.choukri.onlineReservation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domaine.choukri.onlineReservation.service.IReservationService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/dispatcher-config.xml"})
public class Reservation {
	


	@Autowired
	private IReservationService iReservationService;

	@Test
	public void testReservation()
	{
		 List<domaine.choukri.onlineReservation.classes.Reservation> reserveList = iReservationService.getAllReservations();
		 assertEquals(3,reserveList.size());
	}
	@Test
	public void findReservation()
	{
		domaine.choukri.onlineReservation.classes.Reservation r  = iReservationService.findReservationById(6L);
		
		assertNotNull(r);
		 
	}
	
	

}
