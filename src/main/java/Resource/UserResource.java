package Resource;

import Service.UserService;
import dto.UserRegistrationRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.*;

import java.util.List;

import Klase.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Path("/add")
    public User createUser(UserRegistrationRequest request){
        return userService.createUser(request);
    }

    @GET 
    @Path("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
