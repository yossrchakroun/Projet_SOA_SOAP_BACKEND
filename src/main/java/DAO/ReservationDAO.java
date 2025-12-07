package DAO;

import model.Reservation;
import jakarta.persistence.*;
import java.util.List;

public class ReservationDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CampusPU");

    public List<Reservation> getAllReservations() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void addReservation(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(reservation);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public boolean updateReservation(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Reservation existing = em.find(Reservation.class, reservation.getReservation_id());
            if (existing == null) return false;

            existing.setDateDebut(reservation.getDateDebut());
            existing.setDateFin(reservation.getDateFin());
            existing.setTotal(reservation.getTotal());
            existing.setStatut(reservation.getStatut());
            existing.setClientId(reservation.getClientId());
            existing.setChambreId(reservation.getChambreId());

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

    public void deleteReservation(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Reservation reservation = em.find(Reservation.class, id);
            if (reservation != null) em.remove(reservation);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}