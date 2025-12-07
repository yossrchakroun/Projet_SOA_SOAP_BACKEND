package Service;

import model.Reservation;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface IReservation {
    @WebMethod List<Reservation> listerReservations();
    @WebMethod String ajouterReservation(Reservation reservation);
    @WebMethod String modifierReservation(Reservation reservation);
    @WebMethod String supprimerReservation(int id);
}