package Resource;

import java.util.List;

import Service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Produces;
import Klase.Client;

@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

    @Inject
    ClientService clientService;

    @POST
    @Path("/add")
    public Client createClient(Client client){
        return clientService.createClient(client);
    }
     
    @GET 
    @Path("/getAll")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    
}
