package fr.cances.steve.annuaire.spring.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;


@Controller
@RequestMapping("/annuaire")
public class ControllerAnnuaireRest {
	
	@Autowired
	private ServiceAnnuaire serviceAnnuaire;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Collection<PersonneVo>> getAllPersonnes() {
		ResponseEntity<Collection<PersonneVo>> response = new ResponseEntity<>(this.serviceAnnuaire.getAllPersonnes(), HttpStatus.OK);
		return response;
	}
}
