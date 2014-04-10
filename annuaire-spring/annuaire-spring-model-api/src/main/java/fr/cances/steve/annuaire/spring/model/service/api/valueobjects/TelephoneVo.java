package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

public class TelephoneVo {

	public TelephoneVo() {

	}
	
	private Long id;

	private String telephone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
