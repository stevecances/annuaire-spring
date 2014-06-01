package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Utilisateur;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.UtilisateurVo;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * {@link EntityMapper} pour les classes : {@link Utilisateur} et
 * {@link UtilisateurVo}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class EntityMapperUtilisateur extends EntityMapper<Utilisateur, UtilisateurVo, Long> {

    @Inject
    private EntityMapper<Personne, PersonneVo, Long> entityMapperPersonne;

    /**
     * Le status d'administration ({@link Utilisateur#isAdmin()}) et le username
     * ({@link Utilisateur#getUsername()}) ne sont pas modifiés.
     * 
     * @param entity
     *            L'entity à mettre à jour.
     * @param vo
     *            Le vo contenant les nouvelles informations.
     */
    @Override
    public void updateEntityFromVo(final Utilisateur entity, final UtilisateurVo vo) {

        Assert.notNull(entity, "L'utilisateur ne doit pas être null !");
        Assert.notNull(vo, "L'utilisateurVo ne doit pas être null !");

        this.entityMapperPersonne.updateEntityFromVo(
                entity.getPersonne(),
                PersonneVo.Builder
                        .newInstance()
                        .withNom(vo.getNom())
                        .withPrenom(vo.getPrenom())
                        .build());
    }

    @Override
    public UtilisateurVo transform(final Utilisateur utilisateur) {

        Assert.notNull(utilisateur, "L'utilisateur à transformer ne doit pas être null !");

        return UtilisateurVo.Builder
                .newInstance()
                .withId(utilisateur.getId())
                .withUsername(utilisateur.getUsername())
                .withPrenom(utilisateur.getPersonne().getPrenom())
                .withNom(utilisateur.getPersonne().getNom())
                .build();
    }

    /**
     * Par defaut l'utilisateur créé n'est pas administrateur.
     * 
     * @param utilisateurVo
     *            Le vo à reverse.
     * @return L'utilisateur correspondant au vo.
     */
    @Override
    public Utilisateur reverse(final UtilisateurVo utilisateurVo) {

        Assert.notNull(utilisateurVo, "L'utilisateurVo à reverse ne doit pas être null !");

        // Par defaut l'utilisateur créé n'est pas administrateur.
        return Utilisateur.Builder
                .newInstance()
                .withUsername(utilisateurVo.getUsername())
                .withPassword(utilisateurVo.getPassword())
                .withPersonne(Personne.Builder
                        .newInstance()
                        .withNom(utilisateurVo.getNom())
                        .withPrenom(utilisateurVo.getPrenom())
                        .build())
                .withAdmin(false)
                .build();
    }
}
