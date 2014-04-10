package fr.cances.steve.annuaire.spring.model.service.impl;

import java.util.ArrayList;
import java.util.Collection;







import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.cances.steve.annuaire.spring.model.persistence.entities.Personne;
import fr.cances.steve.annuaire.spring.model.persistence.repositories.PersonneRepository;
import fr.cances.steve.annuaire.spring.model.service.api.ServiceAnnuaire;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

@Service
@Transactional
public class ServiceAnnuaireImpl implements ServiceAnnuaire {

	@Autowired
	PersonneRepository personneRepository;

	@Autowired
	DozerBeanMapper dozerMapper;

	@Override
	public Collection<PersonneVo> getAllPersonnes() {
		System.out.println("dozer : "+this.dozerMapper.toString());
		Collection<PersonneVo> personnesVo = new ArrayList<>();
		for(Personne personne : this.personneRepository.findAll()) {
			//personne.getTelephones().size();
			//personnesVo.add(new PersonneVo(personne));
			PersonneVo personneVo = new PersonneVo();
			this.dozerMapper.map(personne, personneVo);
			personnesVo.add(personneVo);
		}

		return personnesVo;
	}

}
