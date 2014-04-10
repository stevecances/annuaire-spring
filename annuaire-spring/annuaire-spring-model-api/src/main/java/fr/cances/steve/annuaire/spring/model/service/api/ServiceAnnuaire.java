package fr.cances.steve.annuaire.spring.model.service.api;

import java.util.Collection;

import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.PersonneVo;

public interface ServiceAnnuaire {
	
	public Collection<PersonneVo> getAllPersonnes();

}
