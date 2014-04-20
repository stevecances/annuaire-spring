/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import org.springframework.stereotype.Component;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Telephone;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class EntityMapperTelephone extends EntityMapper<Telephone, TelephoneVo> {

    @Override
    public void updateEntityFromVo(final Telephone entity, final TelephoneVo vo) {
        if (vo != null && entity != null && vo.getTelephone() != null) {
            entity.setTelephone(vo.getTelephone());
        }
    }

    @Override
    public TelephoneVo transform(final Telephone input) {
        TelephoneVo telephoneVo = null;
        if (input != null) {
            telephoneVo = new TelephoneVo();
            telephoneVo.setId(input.getId());
            telephoneVo.setTelephone(input.getTelephone());
        }
        return telephoneVo;
    }

    @Override
    public Telephone reverse(final TelephoneVo output) {
        Telephone telephone = null;
        if (output != null) {
            telephone = new Telephone();
            telephone.setId(output.getId());
            telephone.setTelephone(output.getTelephone());
        }
        return telephone;
    }

}
