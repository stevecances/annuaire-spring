package fr.cances.steve.annuaire.spring.model.service.api.valueobjects;

public class TelephoneVo {

    private Long id;

    private String telephone;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }
}
