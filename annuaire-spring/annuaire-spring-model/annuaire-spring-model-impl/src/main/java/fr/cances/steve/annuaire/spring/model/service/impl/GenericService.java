package fr.cances.steve.annuaire.spring.model.service.impl;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import fr.cances.steve.annuaire.spring.model.persistence.dao.IDao;
import fr.cances.steve.annuaire.spring.model.persistence.entity.IEntity;
import fr.cances.steve.annuaire.spring.model.service.api.IService;
import fr.cances.steve.annuaire.spring.model.service.api.exception.BeanValidationException;
import fr.cances.steve.annuaire.spring.model.service.api.exception.ResourceNotFoundException;
import fr.cances.steve.annuaire.spring.model.service.api.valueobjects.AbstractVo;
import fr.cances.steve.annuaire.spring.model.service.impl.exception.ExceptionHelper;
import fr.cances.steve.annuaire.spring.model.service.impl.mapping.EntityMapper;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.BeanValidator;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.CreateGroup;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.group.EditGroup;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.vo.IVoValidation;
import fr.cances.steve.annuaire.spring.model.service.impl.validation.vo.VoValidationGenerator;
import fr.cances.steve.annuaire.spring.support.logger.Logger;
import fr.cances.steve.annuaire.spring.support.logger.LoggerFactory;

/**
 * @author Steve Cancès
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class GenericService<E extends IEntity<P>, V extends AbstractVo<P>, A extends IVoValidation<V, P>, P> implements IService<V, P> {

    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericService.class);

    /** La classe de l'entity gérée par le Process */
    private final Class<E> entityClass;

    /** La classe du vo gérée par le Process */
    private final Class<V> voClass;

    /** La classe du vo de validation gérée par le Process */
    private final Class<A> voValidationClass;

    /** Le générateur de vo validation */
    private final VoValidationGenerator<V, A, P> voValidationGenerator;

    /** Le validateur de voValidation */
    @Inject
    private BeanValidator<V, P> validator;

    @Inject
    /** Le DAO */
    private IDao<E, P> dao;

    @Inject
    /** L'entity mapper IEntity <-> AbstractVo */
    private EntityMapper<E, V, P> entityMapper;

    @Inject
    private ExceptionHelper exceptionHelper;

    /**
     * Constructeur par defaut.
     * 
     * @author Steve Cancès
     * @since 1.0.0
     * @param entityClass
     *            La classe de l'entity.
     * @param voClass
     *            La classe du vo.
     * @param voValidationClass
     *            La classe du voValidation.
     */
    public GenericService(final Class<E> entityClass, final Class<V> voClass, final Class<A> voValidationClass) {

        Assert.notNull(entityClass, "entityClass must not be null !");
        Assert.notNull(voClass, "voClass must not be null !");
        Assert.notNull(voValidationClass, "voValidationClass classe must not be null !");

        this.entityClass = entityClass;
        this.voClass = voClass;
        this.voValidationClass = voValidationClass;
        this.voValidationGenerator = VoValidationGenerator.with(voValidationClass);
    }

    /**
     * @return the voClass
     */
    public Class<V> getVoClass() {
        return voClass;
    }

    /**
     * @return the dao
     */
    public IDao<E, P> getDao() {
        return dao;
    }

    /**
     * @return the exceptionHelper
     */
    public ExceptionHelper getExceptionHelper() {
        return exceptionHelper;
    }

    @Transactional(readOnly = true)
    @Override
    public Collection<V> findAll() {
        return this.entityMapper.transform(this.dao.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public V find(final P id) throws ResourceNotFoundException {
        E entity = this.dao.find(id);
        if (entity != null) {
            return this.entityMapper.transform(entity);
        } else {
            this.exceptionHelper.throwResourceNotFoundException(voClass, id.toString());
            return null;
        }
    }

    @Transactional
    @Override
    public V create(final V vo) throws BeanValidationException {
        return this.validateReverseCreateTransform(vo);
    }

    @Transactional
    @Override
    public V edit(final V vo) throws BeanValidationException, ResourceNotFoundException {
        return this.validateUpdateentityEditTransform(vo);
    }

    @Transactional
    @Override
    public void delete(final P id) {
        this.dao.removeById(id);
    }

    // CREATION ET EDITION

    protected void validate(final V vo, final Class<?> groups) throws BeanValidationException {
        this.validator.validate(this.voValidationGenerator.getVoValidation(vo), groups);
    }

    // CREATION

    protected V validateReverseCreateTransform(final V vo)
            throws BeanValidationException {

        LOGGER.debug("validate -> reverse -> create -> transform : %s", vo);
        this.validateCreate(vo);
        return reverseCreateTransform(vo);
    }

    protected void validateCreate(final V vo) throws BeanValidationException {
        this.validate(vo, CreateGroup.class);
    }

    protected V reverseCreateTransform(final V vo)
            throws BeanValidationException {

        LOGGER.debug("reverse -> create -> transform : %s", vo);
        return this.entityMapper.transform(this.reverseCreate(vo));
    }

    protected E reverseCreate(final V vo) {

        LOGGER.debug("reverse -> create input : %s", vo);
        final E created = this.dao.create(this.reverse(vo));
        LOGGER.debug("reverse -> create output : %s", created);
        return created;
    }

    protected E reverse(final V vo) {

        LOGGER.debug("reverse input : %s", vo);
        final E reversed = this.entityMapper.reverse(vo);
        LOGGER.debug("reverse output : %s", reversed);
        return reversed;
    }

    // EDITION

    protected V validateUpdateentityEditTransform(final V vo)
            throws BeanValidationException, ResourceNotFoundException {

        LOGGER.debug("validate -> update entity -> edit -> transform : %s", vo);
        this.validateEdit(vo);
        return updateentityEditTransform(vo);
    }

    protected void validateEdit(final V vo) throws BeanValidationException {
        this.validate(vo, EditGroup.class);
    }

    protected V updateentityEditTransform(final V vo)
            throws BeanValidationException, ResourceNotFoundException {

        LOGGER.debug("update entity -> edit -> transform : %s", vo);
        return this.entityMapper.transform(this.updateentityEdit(vo));
    }

    protected E updateentityEdit(final V vo) throws ResourceNotFoundException {

        LOGGER.debug("update entity -> edit input : %s", vo);
        final E edited = this.dao.edit(this.updateentity(vo));
        LOGGER.debug("update entity -> edit output : %s", edited);
        return edited;
    }

    protected E updateentity(final V vo) throws ResourceNotFoundException {
        E entity = this.dao.find(vo.getId());
        if (entity != null) {
            this.entityMapper.updateEntityFromVo(entity, vo);
            return entity;
        } else {
            LOGGER.debug("entity non trouvée pour l'id : %s. levée d'une ResourceNotFoundException.", vo.getId());
            this.exceptionHelper.throwResourceNotFoundException(voClass, vo.getId().toString());
            return null;
        }
    }

}
