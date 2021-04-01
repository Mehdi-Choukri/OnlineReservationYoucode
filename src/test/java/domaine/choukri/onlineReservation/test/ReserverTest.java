package domaine.choukri.onlineReservation.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domaine.choukri.onlineReservation.classes.Reserver;
import domaine.choukri.onlineReservation.service.IReserverService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/dispatcher-config.xml"})
public class ReserverTest {


	@Autowired
	private IReserverService iReserverService;
	
	@Test
	public void testReserverSize()
	{
		List<Reserver> reserveLists = iReserverService.getAllReservations();
		
		assertEquals(3,reserveLists.size());
	}
	

	@Test
	public void testReserverfindByID()
	{
		 Reserver reserve  = iReserverService.findReservationById(1L);
		
		assertEquals(4,reserve.getNbrPlace());
	}
	
	 
}
