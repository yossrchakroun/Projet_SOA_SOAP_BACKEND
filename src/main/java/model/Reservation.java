// src/main/java/model/Reservation.java
package model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    @Column(name = "date_debut")
    private String dateDebut;
    @Column(name = "date_fin")
    private String dateFin;
    private double total;
    private String statut;

    @Column(name = "client_id")
    private int clientId;
    @Column(name = "chambre_id")
    private int chambreId;

    public Reservation() {}

    // Getters et Setters
    public int getReservation_id() { return reservation_id; }
    public void setReservation_id(int reservation_id) { this.reservation_id = reservation_id; }

    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }

    public String getDateFin() { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getStatut() { return statut; }
    public void setStatut(String status) { this.statut = status; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public int getChambreId() { return chambreId; }
    public void setChambreId(int chambreId) { this.chambreId = chambreId; }
}