package fr.cances.steve.annuaire.spring.model.service.api;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

/**
 * Services annuaire d'administration
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface ServiceAnnuaireAdmin {

	/**
	 * Créer une personne dans l'annuaire (id ignoré car généré automatiquement)
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param personneVo La personne à créer
	 * @return La personne créée (avec l'id généré)
	 */
	public PersonneVo createPersonne(PersonneVo personneVo);

	/**
	 * Edite la personne identifiée par idPersonne (si elle existe)
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param idPersonne L'id de la personne à éditer
	 * @param personneVo Les informations à editer pour la personne concernée
	 * @return La personne éditée (et null sinon)
	 */
	public PersonneVo editPersonne(Long idPersonne, PersonneVo personneVo);

	/**
	 * Supprime la personne identifiée par idPersonne (si elle existe)
	 * 
	 * @author Steve Cancès
	 * @Since 1.0.0
	 * 
	 * @param idPersonne L'id de la personne à supprimer
	 */
	public void deletePersonne(Long idPersonne);
}
