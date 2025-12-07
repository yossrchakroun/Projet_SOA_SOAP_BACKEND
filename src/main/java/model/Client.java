package model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;

    private String nom;
    private String email;
    private String telephone;
    private String type_client;
    private String organisation;

    public Client() {}

    // Getters et Setters
    public int getClient_id() { return client_id; }
    public void setClient_id(int client_id) { this.client_id = client_id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getType_client() { return type_client; }
    public void setType_client(String type_client) { this.type_client = type_client; }

    public String getOrganisation() { return organisation; }
    public void setOrganisation(String organisation) { this.organisation = organisation; }
}