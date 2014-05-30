package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import fr.cances.steve.annuaire.spring.model.persistence.entity.Telephone;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * {@link EntityMapper} pour les classes : {@link Telephone} et
 * {@link TelephoneVo}.
 * 
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class EntityMapperTelephone extends EntityMapper<Telephone, TelephoneVo, Long> {

    @Override
    public void updateEntityFromVo(final Telephone entity, final TelephoneVo vo) {

        Assert.notNull(entity, "Le telephone ne doit pas être null !");
        Assert.notNull(vo, "Le telephoneVo ne doit pas être null !");

        entity.setTelephone(vo.getTelephone());
    }

    @Override
    public TelephoneVo transform(final Telephone telephone) {

        Assert.notNull(telephone, "Le telephone à transform ne doit pas être null !");

        TelephoneVo telephoneVo = new TelephoneVo();
        telephoneVo.setId(telephone.getId());
        telephoneVo.setTelephone(telephone.getTelephone());
        return telephoneVo;
    }

    @Override
    public Telephone reverse(final TelephoneVo telephoneVo) {

        Assert.notNull(telephoneVo, "Le telephoneVo à reverse ne doit pas être null !");

        Telephone telephone = new Telephone();
        telephone.setTelephone(telephoneVo.getTelephone());
        return telephone;
    }

}
