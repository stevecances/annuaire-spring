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
	
	public void updateTelephoneFromTelephoneVo(TelephoneVo telephoneVo, Telephone telephone) {
		if(telephoneVo != null && telephone != null) {
			if(telephoneVo.getTelephone() != null) {
				telephone.setTelephone(telephone.getTelephone());
			}
		}
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
	
	public void updatePersonneFromPersonneVo(PersonneVo personneVo, Personne personne) {
		if(personne != null && personneVo != null) {
			if(personneVo.getNom() != null) {
				personne.setNom(personneVo.getNom());
			}
			if(personneVo.getPrenom() != null) {
				personne.setPrenom(personneVo.getPrenom());
			}
			if(personneVo.getTelephones() != null) {
				Collection<Telephone> telephones = personne.getTelephones();
				telephones.clear();
				for(TelephoneVo telephoneVo : personneVo.getTelephones()) {
					telephones.add(this.telephoneVoToTelephone(telephoneVo));
				}
			}
		}
	}

}
