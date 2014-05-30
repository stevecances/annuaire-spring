package fr.cances.steve.annuaire.spring.ws.controllers;

import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaireAdmin;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controleur Annuaire
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequestMapping("/annuaire")
public class ControllerAnnuaireRest {

    /*
     * CONSULTATION
     */
    /**
     * Le service de consultation de l'annuaire
     */
    @Inject
    private ServiceAnnuaire serviceAnnuaire;

    /**
     * Le service d'aministration de l'annuiare
     */
    @Inject
    private ServiceAnnuaireAdmin serviceAnnuaireAdmin;

    /**
     * Récupérer l'ensemble des personnes de l'annuaire
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return l'ensemble des personnes de l'annuaire
     */
    @RequestMapping(value = "/personne", method = RequestMethod.GET)
    public ResponseEntity<Collection<PersonneVo>> getAllPersonnes() {
        return new ResponseEntity<>(this.serviceAnnuaire.getAllPersonnes(), HttpStatus.OK);
    }

    /**
     * Récupérer une personne de l'annuaire avec son id
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idPersonne
     *            L'id de la personne demandée
     * @return La personne demandée si elle existe (sinon 404)
     */
    @RequestMapping(value = "/personne/{idPersonne}", method = RequestMethod.GET)
    public ResponseEntity<PersonneVo> getPersonne(@PathVariable final Long idPersonne) {
        ResponseEntity<PersonneVo> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
        if (personneVo != null) {
            response = new ResponseEntity<>(personneVo, HttpStatus.OK);
        }
        return response;
    }

    /**
     * Récupérer les telephones d'une personne de l'annuaire avec son id
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idPersonne
     *            L'id de la personne
     * @return les telephones de la personne si elle existe (sinon 404)
     */
    @RequestMapping(value = "/personne/{idPersonne}/telephones", method = RequestMethod.GET)
    public ResponseEntity<Collection<TelephoneVo>> getTelephonesPersonne(@PathVariable final Long idPersonne) {
        ResponseEntity<Collection<TelephoneVo>> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
        if (personneVo != null) {
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
     * @since 1.0.0
     * @param personneVo
     *            La personne à créer
     * @return La personne créée (avec l'id généré)
     */
    @RequestMapping(value = "/personne", method = RequestMethod.POST)
    public ResponseEntity<PersonneVo> createPersonne(@RequestBody final PersonneVo personneVo) {
        return new ResponseEntity<>(this.serviceAnnuaireAdmin.createPersonne(personneVo), HttpStatus.CREATED);
    }

    /**
     * Edite une personne
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idPersonne
     *            L'id de la personne à editer
     * @param personneVo
     *            Les nouvelles informations de la personne
     * @return La personne éditée
     */
    @RequestMapping(value = "/personne/{idPersonne}", method = RequestMethod.PUT)
    public ResponseEntity<PersonneVo> editPersonne(@PathVariable final Long idPersonne, @RequestBody final PersonneVo personneVo) {
        ResponseEntity<PersonneVo> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PersonneVo personneVoOld = this.serviceAnnuaire.getPersonne(idPersonne);
        if (personneVoOld != null) {
            response = new ResponseEntity<>(this.serviceAnnuaireAdmin.editPersonne(idPersonne, personneVo), HttpStatus.OK);
        }
        return response;
    }

    /**
     * Supprime une personne de l'annuaire
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idPersonne
     *            L'id de la personne à supprimer
     * @return La reponse (404 si personne non trouvée)
     */
    @RequestMapping(value = "/personne/{idPersonne}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePersonne(@PathVariable final Long idPersonne) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        PersonneVo personneVo = this.serviceAnnuaire.getPersonne(idPersonne);
        if (personneVo != null) {
            this.serviceAnnuaireAdmin.deletePersonne(idPersonne);
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        return response;
    }

    /**
     * Ajoute un telephone à une personne
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idPersonne
     *            L'identifiant de la personne concernée.
     * @param telephoneVo
     *            Les informations du telephone à ajouter.
     * @return Le téléphone créé (404 si personne non trouvée)
     */
    @RequestMapping(value = "/personne/{idPersonne}/telephones", method = RequestMethod.POST)
    public ResponseEntity<TelephoneVo> createTelephone(@PathVariable final Long idPersonne, @RequestBody final TelephoneVo telephoneVo) {
        ResponseEntity<TelephoneVo> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        TelephoneVo telephoneVoReturn = this.serviceAnnuaireAdmin.createTelephone(idPersonne, telephoneVo);
        if (telephoneVoReturn != null) {
            response = new ResponseEntity<>(telephoneVoReturn, HttpStatus.CREATED);
        }
        return response;
    }

    /**
     * Edite un telephone
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idTelephone
     *            L'id du téléphone à éditer
     * @param telephoneVo
     *            Les nouvelles informations du téléphone
     * @return Le téléphone édité
     */
    @RequestMapping(value = "/telephone/{idTelephone}", method = RequestMethod.PUT)
    public ResponseEntity<TelephoneVo> editTelephone(@PathVariable final Long idTelephone, @RequestBody final TelephoneVo telephoneVo) {
        ResponseEntity<TelephoneVo> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        TelephoneVo telephoneVoReturn = this.serviceAnnuaireAdmin.editTelephone(idTelephone, telephoneVo);
        if (telephoneVoReturn != null) {
            response = new ResponseEntity<>(telephoneVoReturn, HttpStatus.OK);
        }
        return response;
    }

    /**
     * @author Steve Cancès
     * @since 1.0.0
     * @param idTelephone
     *            l'id du téléphone à supprimer
     * @return La reponse (404 si téléphone non trouvé)
     */
    @RequestMapping(value = "/telephone/{idTelephone}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTelephone(@PathVariable final Long idTelephone) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (idTelephone != null) {
            TelephoneVo telephoneVo = this.serviceAnnuaire.getTelephone(idTelephone);
            if (telephoneVo != null) {
                this.serviceAnnuaireAdmin.deleteTelephone(idTelephone);
                response = new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return response;
    }
}
