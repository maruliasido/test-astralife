package com.maruliastra.maruli.base;


import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

@NoRepositoryBean
public class BaseRepository<E, F> extends SimpleJpaRepository<E, F> {

    protected final EntityManager em;

    public BaseRepository(Class<E> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
    }

    public E add(E entity) {
        return saveAndFlush(entity);
    }

    public E edit(E entity) {
        return saveAndFlush(entity);
    }

    public void customFlush() {
        em.flush();
        em.clear();
    }

}