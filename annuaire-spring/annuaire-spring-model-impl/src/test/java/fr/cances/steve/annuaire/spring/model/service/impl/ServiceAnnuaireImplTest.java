/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.cances.steve.annuaire.spring.model.persistence.config.TestPersistenceConfig;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.jpa.AbstractRepositoryJpaTest;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestPersistenceConfig.class})
public class ServiceAnnuaireImplTest extends AbstractRepositoryJpaTest {

	@Autowired
	private ServiceAnnuaire serviceAnnuaire;

	@Autowired
	private ServiceAnnuaireAdmin serviceAnnuaireAdmin;

	public static boolean dbInit = false;
	
	public static Long idPersonne;

	@Before
	public void before() {
		if(!dbInit){
			
			this.truncateSchemaPublic();
			
			PersonneVo personneVo = new PersonneVo();
			personneVo.setNom("Cancès");
			personneVo.setPrenom("Steve");
			personneVo = this.serviceAnnuaireAdmin.createPersonne(personneVo);
			idPersonne = personneVo.getId();
			
			personneVo = new PersonneVo();
			personneVo.setNom("Nom");
			personneVo.setPrenom("Prenom");
			this.serviceAnnuaireAdmin.createPersonne(personneVo);
			
			dbInit = true;
		}
	}

	@Test
	public void testGetAllPersonnes() {
		Collection<PersonneVo> personnesVo = this.serviceAnnuaire.getAllPersonnes();
		assertEquals(2, personnesVo.size());
	}
	
	@Test
	public void testGetPersonne() {
		PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
		assertEquals("Steve", personneVo.getPrenom());
		assertEquals("Cancès", personneVo.getNom());
	}
}
