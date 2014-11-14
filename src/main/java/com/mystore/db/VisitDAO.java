package com.mystore.db;

import java.util.List;

import com.google.common.base.Optional;
import com.mystore.core.Visit;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class VisitDAO extends AbstractDAO<Visit> {
    public VisitDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<Visit> findById(Long id) {
        return Optional.fromNullable(get(id));
    }

    public Visit create(Visit visit) {
        return persist(visit);
    }

    public List<Visit> findAll() {
        return list(namedQuery("com.mystore.core.Visit.findAll"));
    }
}