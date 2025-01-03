package org.example.services;

import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {

    private final Session session;

    public ClientCrudService(Session session) {
        this.session = session;
    }

    public void create(Client client) {
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
    }

    public Client findById(Long id) {
        return session.find(Client.class, id);
    }

    public List<Client> findAll() {
        return session.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public void update(Client client) {
        Transaction transaction = session.beginTransaction();
        session.merge(client);
        transaction.commit();
    }

    public void delete(Client client) {
        Transaction transaction = session.beginTransaction();
        session.remove(client);
        transaction.commit();
    }
}