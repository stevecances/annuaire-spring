package fr.cances.steve.annuaire.spring.ws.controllers;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.UtilisateurVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steve Cances <steve.cances@gmail.com>
 */
@RestController
@RequestMapping("/utilisateurs")
public class RestControllerUtilisateurs extends AbstractRestController<UtilisateurVo, Long> {

}
