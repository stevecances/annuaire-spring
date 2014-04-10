package fr.cances.steve.annuaire.spring.model.persistence.repositories;

import java.util.List;

public interface AbstractRepository<E, I> {

    public abstract E create(E entity);

    public abstract E edit(E entity);

    public abstract void remove(E entity);

    public abstract E find(I id);

    public abstract List<E> findAll();

    public abstract List<E> findRange(int[] range);

    public abstract int count();

}