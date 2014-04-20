package fr.cances.steve.annuaire.spring.model.service.api;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * Services annuaire d'administration
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServiceAnnuaireAdmin {

    /**
     * Créer une personne dans l'annuaire (id ignoré car généré automatiquement)
     * 
     * @author Steve Cancès
     * @Since 1.0.0
     * @param personneVo
     *            La personne à créer
     * @return La personne créée (avec l'id généré)
     */
    public PersonneVo createPersonne(PersonneVo personneVo);

    /**
     * Edite la personne identifiée par idPersonne (si elle existe)
     * 
     * @author Steve Cancès
     * @Since 1.0.0
     * @param idPersonne
     *            L'id de la personne à éditer
     * @param personneVo
     *            Les informations à editer pour la personne concernée
     * @return La personne éditée (et null sinon)
     */
    public PersonneVo editPersonne(Long idPersonne, PersonneVo personneVo);

    /**
     * Supprime la personne identifiée par idPersonne (si elle existe)
     * 
     * @author Steve Cancès
     * @Since 1.0.0
     * @param idPersonne
     *            L'id de la personne à supprimer
     */
    public void deletePersonne(Long idPersonne);

    /**
     * Créer un telephone pour une personne
     * 
     * @author Steve Cancès
     * @Since 1.0.0
     * @param idPersonne
     *            L'identifiant de la pesonne
     * @param telephoneVo
     *            les informations du telephone
     * @return Le téléphone créé
     */
    public TelephoneVo createTelephone(final Long idPersonne, final TelephoneVo telephoneVo);

    /**
     * Editer un telephone
     * 
     * @author Steve Cancès
     * @Since 1.0.0
     * @param idTelephone
     *            L'identifiant du telephone à éditer
     * @param telephoneVo
     *            les nouvelles informations du telephone
     * @return Le téléphone édité
     */
    public TelephoneVo editTelephone(final Long idTelephone, final TelephoneVo telephoneVo);

    /**
     * Supprimer un telephone
     * 
     * @author Steve Cancès
     * @Since 1.0.0
     * @param idTelephone
     *            L'identifiant du telephone à supprimer
     */
    public void deleteTelephone(final Long idTelephone);
}
