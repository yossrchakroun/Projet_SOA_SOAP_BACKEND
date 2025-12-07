package model;
import jakarta.persistence.*;

@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chambre_id;

    private String numero;
    private String type_chambre;
    private int capacite;
    private double prix_par_jour;
    private String equipements;
    private String statut;
    private String description;

    // Constructeur vide
    public Chambre() {}

    // Getters et Setters
    public int getChambre_id() { return chambre_id; }
    public void setChambre_id(int chambre_id) { this.chambre_id = chambre_id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getType_chambre() { return type_chambre; }
    public void setType_chambre(String type_chambre) { this.type_chambre = type_chambre; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }

    public double getPrix_par_jour() { return prix_par_jour; }
    public void setPrix_par_jour(double prix_par_jour) { this.prix_par_jour = prix_par_jour; }

    public String getEquipements() { return equipements; }
    public void setEquipements(String equipements) { this.equipements = equipements; }

    public String getStatut() { return statut; }
    public void setStatut(String status) { this.statut = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

