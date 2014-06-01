package fr.cances.steve.annuaire.spring.ws.controllers;

import fr.cances.steve.annuaire.spring.model.service.api.BasicService;
import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import java.util.Collection;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller REST abstrait fournissant les CRUD de base sur le vo associé.
 * 
 * @author Steve Cances <steve.cances@gmail.com>
 * @param <V>
 *            La classe du vo géré par le controller.
 * @param <P>
 *            La classe de l'identifiant du vo géré par le controller.
 */
public abstract class AbstractRestController<V extends AbstractVo<P>, P> {

    @Inject
    protected BasicService<V, P> basicService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<V> getAll() throws UnsupportedOperationException {
        return this.basicService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public V get(@PathVariable P id) throws UnsupportedOperationException, ResourceNotFoundException {
        return this.basicService.find(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public V create(@RequestBody V vo) throws UnsupportedOperationException, BeanValidationException {
        return this.basicService.create(vo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public V edit(@RequestBody V vo, @PathVariable P id) throws UnsupportedOperationException, ResourceNotFoundException, BeanValidationException {
        vo.setId(id);
        return this.basicService.edit(vo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable P id) throws UnsupportedOperationException {
        this.basicService.delete(id);
    }

}
