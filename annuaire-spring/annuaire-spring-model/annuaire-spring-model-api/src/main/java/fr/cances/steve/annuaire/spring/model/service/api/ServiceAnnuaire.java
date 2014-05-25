package fr.cances.steve.annuaire.spring.model.service.api;

import java.util.Collection;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * Services annuaire (consultation uniquement)
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServiceAnnuaire {

    /**
     * Retourne l'ensemble des personnes de l'annuaire
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @return l'ensemble des personnes de l'annuaire
     */
    public Collection<PersonneVo> getAllPersonnes();

    /**
     * Retourne la personne corresondant à l'idPersonne et null sinon
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idPersonne
     *            L'id de la personne recherchée
     * @return la personne corresondant à l'idPersonne et null sinon
     */
    public PersonneVo getPersonne(Long idPersonne);

    /**
     * Retourne l'ensemble des personnes de l'annuaire dont le nom match avec
     * %like% ou le prénom match avec %like%
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param like
     *            La chaine like
     * @return l'ensemble des personnes de l'annuaire dont le nom match avec
     *         %like% ou le prénom match avec %like%
     */
    public Collection<PersonneVo> findPersonnesLikePrenomOrNom(String like);

    /**
     * Retourne le téléphone correspondant à l'idTelephone et null sinon
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param idTelephone
     * @return le téléphone correspondant à l'idTelephone et null sinon
     */
    public TelephoneVo getTelephone(Long idTelephone);

}
