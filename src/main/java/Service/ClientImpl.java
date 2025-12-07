package Service;

import DAO.ClientDAO;
import jakarta.jws.WebService;
import model.Client;

import java.util.List;

@WebService(endpointInterface = "Service.IClient")
public class ClientImpl implements IClient{
    private final ClientDAO dao = new ClientDAO();

    @Override
    public List<Client> listerClients() {
        return dao.getAllClients();
    }

    @Override
    public String ajouterClient(Client client) {
        dao.addClient(client);
        return "Client ajouté avec succès";    }

    @Override
    public String modifierClient(Client client) {
        boolean ok = dao.updateClient(client);
        return ok ? "Client modifié" : "Erreur";    }

    @Override
    public String supprimerClient(int id) {
        dao.deleteClient(id);
        return "Client supprimé";    }
}
