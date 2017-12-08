package com.gmail.macieq44.motivateme.backend.service;

import com.gmail.macieq44.motivateme.backend.entity.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Macieq44 on 28.11.2017.
 */
public abstract class CrudService<T extends AbstractEntity> {

    protected abstract CrudRepository<T, Long> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(T entity) {
        getRepository().delete(entity);
    }

    public T load(long id) {
        return getRepository().findOne(id);
    }

}
