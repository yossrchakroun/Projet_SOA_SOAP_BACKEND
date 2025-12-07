package Server;

import jakarta.xml.ws.Endpoint;
import Service.ChambreImpl;
import Service.ClientImpl;
import Service.ReservationImpl;

public class ServerJWS {
    public static void main(String[] args) {
        String base = "http://localhost:8080/ProjectSOA_SOAP/ws";

        Endpoint.publish(base + "/chambre", new ChambreImpl());
        Endpoint.publish(base + "/client", new ClientImpl());
        Endpoint.publish(base + "/reservation", new ReservationImpl());

        System.out.println("TOUS LES SERVICES SOAP SONT PUBLIES !");
        System.out.println("Chambre     → " + base + "/chambre?wsdl");
        System.out.println("Client      → " + base + "/client?wsdl");
        System.out.println("Réservation → " + base + "/reservation?wsdl");
        System.out.println("Serveur Lancé ");
    }
}