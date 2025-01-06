package org.example.services;

import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;

public class PlanetCrudService {

    private final Session session;
    private final Validator validator;

    public PlanetCrudService(Session session) {
        this.session = session;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public void create(Planet planet) {
        var violations = validator.validate(planet);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Validation failed: " + violations);
        }

        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
    }

    public Planet findById(String id) {
        return session.find(Planet.class, id);
    }

    public List<Planet> findAll() {
        return session.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }

    public void update(Planet planet) {
        var violations = validator.validate(planet);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Validation failed: " + violations);
        }

        Transaction transaction = session.beginTransaction();
        session.merge(planet);
        transaction.commit();
    }

    public void delete(Planet planet) {
        Transaction transaction = session.beginTransaction();
        session.remove(planet);
        transaction.commit();
    }
}
