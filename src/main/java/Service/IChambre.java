package Service;

import model.Chambre;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IChambre {
    @WebMethod
    List<Chambre> listerChambres();
    @WebMethod String ajouterChambre(Chambre chambre);
    @WebMethod
    String modifierChambre(Chambre chambre);
    @WebMethod String supprimerChambre(int id);
}
