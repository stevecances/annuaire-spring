/**
 *
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entity.Telephone;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * {@link EntityMapper} pour les classes : {@link Personne} et
 * {@link PersonneVo}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class EntityMapperPersonne extends EntityMapper<Personne, PersonneVo, Long> {

    @Inject
    private EntityMapper<Telephone, TelephoneVo, Long> entityMapperTelephone;

    /**
     * Seuls le nom et le prenon sont mis à jour.
     */
    @Override
    public void updateEntityFromVo(final Personne entity, final PersonneVo vo) {

        Assert.notNull(entity, "La personne ne doit pas être null !");
        Assert.notNull(vo, "La personneVo ne doit pas être null !");

        if (vo.getNom() != null) {
            entity.setNom(vo.getNom());
        }
        if (vo.getPrenom() != null) {
            entity.setPrenom(vo.getPrenom());
        }
    }

    @Override
    public PersonneVo transform(final Personne personne) {

        Assert.notNull(personne, "La personne à transform ne doit pas être null !");

        PersonneVo personneVo = new PersonneVo();
        personneVo.setId(personne.getId());
        personneVo.setNom(personne.getNom());
        personneVo.setPrenom(personne.getPrenom());
        if (personne.getTelephones() == null) {
            personneVo.setTelephones(null);
        } else {
            personneVo.setTelephones(this.entityMapperTelephone.transform(personne.getTelephones()));
        }
        return personneVo;
    }

    /**
     * les numeros de téléphones ({@link Personne#getTelephones()}) ne sont pas
     * pris en compte.
     */
    @Override
    public Personne reverse(final PersonneVo personneVo) {

        Assert.notNull(personneVo, "La personneVo à reverse ne doit pas être null !");

        Personne personne = new Personne();
        personne.setNom(personneVo.getNom());
        personne.setPrenom(personneVo.getPrenom());
        return personne;
    }
}
