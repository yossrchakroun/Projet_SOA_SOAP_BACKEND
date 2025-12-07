package DAO;

import model.Client;
import jakarta.persistence.*;
import java.util.List;

public class ClientDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CampusPU");

    public List<Client> getAllClients() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void addClient(Client client) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(client);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public boolean updateClient(Client client) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Client existing = em.find(Client.class, client.getClient_id());
            if (existing == null) return false;

            existing.setNom(client.getNom());
            existing.setEmail(client.getEmail());
            existing.setTelephone(client.getTelephone());
            existing.setType_client(client.getType_client());
            existing.setOrganisation(client.getOrganisation());

            em.merge(existing);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public void deleteClient(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Client client = em.find(Client.class, id);
            if (client != null) em.remove(client);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}