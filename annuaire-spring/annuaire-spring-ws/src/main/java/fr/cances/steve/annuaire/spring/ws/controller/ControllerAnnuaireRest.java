package fr.cances.steve.annuaire.spring.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

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

	/*
	 * CONSULTATION
	 */

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
	 * Récupérer une personne de l'annuaire avec son id
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param idPersonne L'id de la personne demandée
	 * @return La personne demandée si elle existe (sinon 404)
	 */
	@RequestMapping(value = "/{idPersonne}", method = RequestMethod.GET)
	public ResponseEntity<PersonneVo> getPersonne(@PathVariable Long idPersonne) {
		ResponseEntity<PersonneVo> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
		if(personneVo != null) {
			response = new ResponseEntity<PersonneVo>(personneVo, HttpStatus.OK);
		}
		return response;
	}

	/**
	 * Récupérer les telephones d'une personne de l'annuaire avec son id
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param idPersonne L'id de la personne
	 * @return les telephones de la personne si elle existe (sinon 404)
	 */
	@RequestMapping(value = "/{idPersonne}/telephones", method = RequestMethod.GET)
	public ResponseEntity<Collection<TelephoneVo>> getTelephonesPersonne(@PathVariable Long idPersonne) {
		ResponseEntity<Collection<TelephoneVo>> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
		if(personneVo != null) {
			response = new ResponseEntity<>(personneVo.getTelephones(), HttpStatus.OK);
		}
		return response;
	}

	/*
	 * ADMINISTRATION
	 */

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
	
	/**
	 * Edite une personne 
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param idPersonne L'id de la personne à editer
	 * @param personneVo Les nouvelles informations de la personne
	 * @return La personne éditée 
	 */
	@RequestMapping(value = "/{idPersonne}", method = RequestMethod.PUT)
	public ResponseEntity<PersonneVo> editPersonne(@PathVariable Long idPersonne, @RequestBody PersonneVo personneVo) {
		ResponseEntity<PersonneVo> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		PersonneVo personneVoOld = this.serviceAnnuaire.getPersonne(idPersonne);
		if(personneVoOld != null) {
			response = new ResponseEntity<>(this.serviceAnnuaireAdmin.editPersonne(idPersonne, personneVo), HttpStatus.OK);
		}
		return response;
	}
	
	/**
	 * Supprime une personne de l'annuaire
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param idPersonne L'id de la personne à supprimer
	 * @return La reponse (404 si personne non trouvée)
	 */
	public ResponseEntity<Void> deletePersonne(@PathVariable Long idPersonne) {
		ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
		if(personneVo != null) {
			this.serviceAnnuaireAdmin.deletePersonne(idPersonne);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
}
