package fr.cances.steve.annuaire.spring.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/infos")
public class ControllerInfosRest {
	
	public static final String VERSION = "1.0.0";
	
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public ResponseEntity<String> getVersion(){
		return new ResponseEntity<>(VERSION, HttpStatus.OK);
	}
}
