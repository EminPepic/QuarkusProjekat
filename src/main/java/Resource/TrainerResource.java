package Resource;

import java.util.List;

import Klase.Trainer;
import Service.TrainerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/trainers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrainerResource {

    @Inject
    TrainerService trainerService;

    @POST
    @Path("/add")
    public Trainer createTrainer(Trainer trainer){
        return trainerService.createTrainer(trainer);
    }

    @GET 
    @Path("/getAll")
    public List<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();
    }
    
}
