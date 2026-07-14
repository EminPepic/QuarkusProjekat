package Service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import Klase.Client;

@ApplicationScoped
public class ClientService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Client createClient(Client client){
        entityManager.persist(client);
        return client;
    }

    public List<Client> getAllClients(){
        return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
    
}
