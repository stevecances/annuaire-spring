/**
 * 
 */
package fr.cances.steve.annuaire.spring.model.service.impl.mapping;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.entities.Telephone;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.TelephoneVo;

/**
 * @author Steve Cancès
 * @version 1.0.0 
 * @since 1.0.0
 *
 */
@Component("HandyBeanMapper")
public class HandyBeanMapper implements BeanMapper {

	@Override
	public TelephoneVo telephoneToTelephoneVo(Telephone telephone) {
		TelephoneVo telephoneVo = null;
		if(telephone != null) {
			telephoneVo = new TelephoneVo();
			telephoneVo.setId(telephone.getId());
			telephoneVo.setTelephone(telephone.getTelephone());
		}
		return telephoneVo;
	}

	@Override
	public Telephone telephoneVoToTelephone(TelephoneVo telephoneVo) {
		Telephone telephone = null;
		if(telephoneVo != null) {
			telephone = new Telephone();
			telephone.setId(telephoneVo.getId());
			telephone.setTelephone(telephoneVo.getTelephone());
		}
		return telephone;
	}

	@Override
	public PersonneVo personneToPersonneVo(Personne personne) {
		PersonneVo personneVo = null;
		if(personne != null) {
			personneVo = new PersonneVo();
			personneVo.setId(personne.getId());
			personneVo.setNom(personne.getNom());
			personneVo.setPrenom(personne.getPrenom());
			if(personne.getTelephones() == null) {
				personneVo.setTelephones(null);
			} else {
				Collection<TelephoneVo> telephonesVo = new ArrayList<>();
				personneVo.setTelephones(telephonesVo);
				for(Telephone telephone : personne.getTelephones()) {
					telephonesVo.add(this.telephoneToTelephoneVo(telephone));
				}
			}
		}
		return personneVo;
	}

	@Override
	public Personne personneVoToPersonne(PersonneVo personneVo) {
		Personne personne = null;
		if(personneVo != null) {
			personne = new Personne();
			personne.setId(personneVo.getId());
			personne.setNom(personneVo.getNom());
			personne.setPrenom(personneVo.getPrenom());
			if(personneVo.getTelephones() == null) {
				personne.setTelephones(null);
			} else {
				Collection<Telephone> telephones = new ArrayList<>();
				personne.setTelephones(telephones);
				for(TelephoneVo telephoneVo : personneVo.getTelephones()) {
					Telephone telephone = this.telephoneVoToTelephone(telephoneVo);
					telephone.setPersonne(personne);
					telephones.add(telephone);
				}
			}
		}
		return personne;
	}

}
