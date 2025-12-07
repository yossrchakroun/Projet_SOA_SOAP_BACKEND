package Service;

import model.Chambre;
import DAO.ChambreDAO;
import jakarta.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "Service.ChambreImpl")
public class ChambreImpl implements IChambre{
        private final ChambreDAO dao = new ChambreDAO();

        @Override
        public List<Chambre> listerChambres() {
            return dao.getAllChambres();
        }

        @Override
        public String ajouterChambre(Chambre chambre) {
            dao.addChambre(chambre);
            return "Chambre ajoutée avec succès";
        }

        @Override
        public String modifierChambre(Chambre chambre) {
            boolean ok = dao.updateChambre(chambre);
            return ok ? "Chambre modifiée" : "Erreur";
        }

        @Override
        public String supprimerChambre(int id) {
            dao.deleteChambre(id);
            return "Chambre supprimée";
        }

}
