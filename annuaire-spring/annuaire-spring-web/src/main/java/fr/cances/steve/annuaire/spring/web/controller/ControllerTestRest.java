package fr.cances.steve.annuaire.spring.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ControllerTestRest {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Boolean> test(){
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
