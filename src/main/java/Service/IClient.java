package Service;

import model.Client;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface IClient {
    @WebMethod List<Client> listerClients();
    @WebMethod String ajouterClient(Client client);
    @WebMethod String modifierClient(Client client);
    @WebMethod String supprimerClient(int id);
}