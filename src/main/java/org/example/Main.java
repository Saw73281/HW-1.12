package org.example;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.services.ClientCrudService;
import org.example.services.PlanetCrudService;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ClientCrudService clientService = new ClientCrudService(session);
            PlanetCrudService planetService = new PlanetCrudService(session);

            List<Client> clients = List.of(
                    new Client("John Doe"),
                    new Client("Jane Smith")
            );
            clients.forEach(clientService::create);

            List<Planet> planets = List.of(
                    new Planet("MARS", "Mars"),
                    new Planet("VEN", "Venus")
            );
            planets.forEach(planetService::create);

            System.out.println("All Clients: " + clientService.findAll());

            System.out.println("All Planets: " + planetService.findAll());

            Client clientToUpdate = clients.get(0);
            clientToUpdate.setFullName("John Updated");
            clientService.update(clientToUpdate);

            Planet planetToDelete = planets.get(1);
            planetService.delete(planetToDelete);

            System.out.println("All Planets after deletion: " + planetService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}
