package fr.cances.steve.annuaire.spring.model.service.api;

import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.UtilisateurVo;

/**
 * Service gerant les {@link UtilisateurVo}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ServiceUtilisateur extends BasicService<UtilisateurVo, Long> {

    /**
     * Modifie le statut d'administrateur de l'utilisateur.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param id
     *            L'identifiant de l'utilisateur.
     * @param admin
     *            Le nouveau statut d'administrateur de l'utilisateur (vrai si
     *            administrateur).
     * @throws ResourceNotFoundException
     *             Si l'utilisateur n'est pas trouvé.
     */
    public void setAdmin(Long id, boolean admin) throws ResourceNotFoundException;
}
