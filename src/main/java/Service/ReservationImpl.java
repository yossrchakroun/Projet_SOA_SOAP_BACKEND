package Service;

import DAO.ReservationDAO;
import jakarta.jws.WebService;
import model.Reservation;

import java.util.List;

@WebService(endpointInterface = "Service.IReservation")
public class ReservationImpl implements IReservation{
    private final ReservationDAO dao = new ReservationDAO();
    @Override
    public List<Reservation> listerReservations() {
        return dao.getAllReservations();    }

    @Override
    public String ajouterReservation(Reservation reservation) {
        dao.addReservation(reservation);
        return "Réservation ajoutée avec succès";    }

    @Override
    public String modifierReservation(Reservation reservation) {
        boolean ok = dao.updateReservation(reservation);
        return ok ? "Réservation modifiée" : "Erreur";    }

    @Override
    public String supprimerReservation(int id) {
        dao.deleteReservation(id);
        return "Réservation supprimée";    }
}
