package org.example.services;

import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {

    private final Session session;

    public PlanetCrudService(Session session) {
        this.session = session;
    }

    public void create(Planet planet) {
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
