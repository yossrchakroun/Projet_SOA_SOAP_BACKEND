package DAO;

import model.Chambre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class ChambreDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CampusPU");

    // Lister toutes les chambres
    public List<Chambre> getAllChambres() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Chambre c", Chambre.class).getResultList();
        } finally {
            em.close();
        }
    }

    // Ajouter une chambre
    public void addChambre(Chambre chambre) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(chambre);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Modifier une chambre
    public boolean updateChambre(Chambre chambre) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Chambre existing = em.find(Chambre.class, chambre.getChambre_id());
            if (existing == null) return false;

            existing.setNumero(chambre.getNumero());
            existing.setType_chambre(chambre.getType_chambre());
            existing.setCapacite(chambre.getCapacite());
            existing.setPrix_par_jour(chambre.getPrix_par_jour());
            existing.setEquipements(chambre.getEquipements());
            existing.setDescription(chambre.getDescription());
            existing.setStatut(chambre.getStatut());

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

    // Supprimer une chambre
    public void deleteChambre(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Chambre chambre = em.find(Chambre.class, id);
            if (chambre != null) {
                em.remove(chambre);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
