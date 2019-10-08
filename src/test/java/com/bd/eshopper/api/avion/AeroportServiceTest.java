package com.bd.eshopper.api.avion;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bd.eshopper.api.avion.dao.AeroportRepository;
import com.bd.eshopper.api.avion.entity.Aeroport;
import com.bd.eshopper.api.avion.entity.TerminalAero;
import com.bd.eshopper.api.avion.service.AeroportMetier;
import com.bd.eshopper.api.avion.service.imp.AeroportImpl;

/**
 * 
 * @author yzaghir
 * Utilisation de Junit 5
 * RunWith remplacer par ExtendWith         @-RunWith(SpringRunner.class)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AeroportServiceTest {

	private static Logger logger = LoggerFactory.getLogger(AeroportServiceTest.class);
	
	@Mock
	private AeroportRepository aeroportRepository ;
	
	@InjectMocks
	private AeroportMetier aeroportService = new AeroportImpl();
	
	@Before
    public void repositoryfindAll() {
		List<Aeroport> listAeroport = new ArrayList() ;
		List<TerminalAero> listTerminaux = new ArrayList();
		listTerminaux.add(new TerminalAero(01L, "Terminal 1"));
		listTerminaux.add(new TerminalAero(02L, "Terminal 2"));
		listTerminaux.add(new TerminalAero(02L, "Terminal 2"));
		listAeroport.add(new Aeroport(01L,"S01","123 rue charle" , "Paris" ,"France" , listTerminaux));
		listAeroport.add(new Aeroport(02L,"S02","123 rue Mario" , "Orly" ,"France" , listTerminaux));
		listAeroport.add(new Aeroport(03L,"S03","123 rue de la station" , "Lyon" ,"France" , listTerminaux));
        when(aeroportRepository.findAll()).thenReturn(listAeroport);
        
        when(aeroportRepository.getOne(02L)).thenReturn(new Aeroport(02L,"S02","123 rue Mario" , "Orly" ,"France" , listTerminaux) );
        		
        //doNothing().when(aeroportRepository.deleteById(02L));
        doAnswer(new Answer<Integer>(){

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
			      logger.info("-----------called with arguments: {}", Arrays.toString(args));
			      listAeroport.remove(1);
			      
				return null;
			}}).when(aeroportRepository).deleteById(02L);
        
        
        Aeroport aeroportCasa = new Aeroport(99L,"C01","52 houbous" , "Casablanca" ,"Maroc" , listTerminaux) ;
        
              
    }
	
	@Test
	public void je_recupere_les_3_aeroport_avec_mon_service() {				
		logger.info("AeroportServiceTest:je_recupere_les_3_aeroport_avec_mon_service()");
		assertEquals(3, aeroportService.getAll().size());
		aeroportService.findOne(01L);
	}
	@Test
	public void je_recupere_l_aeroport_ref_2_de_orly() {
		logger.info("AeroportServiceTest:je_recupere_l_aeroport_ref_2_de_orly()");
		assertEquals("Orly",aeroportService.findOne(02L).getVille());
	}
	@Test
	public void je_ne_recupere_pas_l_aeroport_de_orly_ref_2() {
		logger.info("AeroportServiceTest:je_recupere_l_aeroport_ref_2_de_orly()");
		assertEquals(null,aeroportService.findOne(01L));
	}
	
	@Test
	public void suprimer_l_aeroport_d_orly_ref_02() {
		aeroportService.delete(02L);
		assertEquals(2,aeroportService.getAll().size());
	}
		
	
	
}
