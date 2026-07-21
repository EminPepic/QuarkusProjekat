package Resource;

import Service.UserService;
import dto.UserRegistrationRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

    @GET
    @Path("/getById")
    public User getUserById(@QueryParam("id") Long id){
        return userService.getUserById(id);
    }

    @GET 
    @Path("/exists")
    public Response existsUser(@QueryParam("username") String username, @QueryParam("password") String password){
        var user = userService.existsUser(username, password);
        if (user != null) {
            return Response.ok(user).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

}
