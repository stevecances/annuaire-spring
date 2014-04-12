package fr.cances.steve.annuaire.spring.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * Controleur Annuaire
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Controller
@RequestMapping("/annuaire")
public class ControllerAnnuaireRest {
	
	/**
	 * Le service de consultation de l'annuaire
	 */
	@Autowired
	private ServiceAnnuaire serviceAnnuaire;
	
	/**
	 * Le service d'aministration de l'annuiare
	 */
	@Autowired
	private ServiceAnnuaireAdmin serviceAnnuaireAdmin;

	/**
	 * Récupérer l'ensemble des personnes de l'annuaire
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @return l'ensemble des personnes de l'annuaire
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Collection<PersonneVo>> getAllPersonnes() {
		ResponseEntity<Collection<PersonneVo>> response = new ResponseEntity<>(this.serviceAnnuaire.getAllPersonnes(), HttpStatus.OK);
		return response;
	}
	
	
	/**
	 * Créer une personne
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param personneVo La personne à créer
	 * @return La personne créée (avec l'id généré)
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<PersonneVo> createPersonne(@RequestBody PersonneVo personneVo) {
		ResponseEntity<PersonneVo> response = new ResponseEntity<>(this.serviceAnnuaireAdmin.createPersonne(personneVo), HttpStatus.CREATED);
		return response;
	}
}
