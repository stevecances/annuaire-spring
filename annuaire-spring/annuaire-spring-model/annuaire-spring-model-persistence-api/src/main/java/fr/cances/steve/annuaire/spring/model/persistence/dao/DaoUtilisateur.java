package fr.cances.steve.annuaire.spring.model.persistence.dao;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;

/**
 * Repository gérant l'entity {@link Utilisateur}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DaoUtilisateur extends IDao<Utilisateur, Long> {

    /**
     * Recupere un {@link Utilisateur} par son username.
     * <p>
     * Retourne {@code null} si aucun unilisateur ne coorrespond.
     * </p>
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param username
     *            Le username.
     * @return L'{@link Utilisateur}.
     */
    public Utilisateur findByUsername(String username);
}
