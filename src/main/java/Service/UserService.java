package Service;

import java.util.List;

import Klase.Trainer;
import Klase.User;
import Klase.Client;
import dto.UserRegistrationRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.QueryParam;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;

    @Inject
    TrainerService trainerService;

    @Inject
    ClientService clientService;

    @Transactional
    public User createUser(UserRegistrationRequest request){

        if(request.getUsername() == null || request.getEmail() == null || request.getPassword() == null || request.getRole() == null){
            return null;
        }

        if(entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", request.getUsername())
                .getResultList().size() > 0){
            return null;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        entityManager.persist(user);

        if ("trainer".equalsIgnoreCase(request.getRole())) {
            Trainer trainer = new Trainer();
            trainer.setUser(user);
            trainer.setFirstname(request.getFirstname());
            trainer.setLastname(request.getLastname());
            trainer.setPhone(request.getPhone());
            trainer.setSpecialization(request.getSpecialization());
            trainerService.createTrainer(trainer);
        }else if("client".equalsIgnoreCase(request.getRole())){
            Client client = new Client();
            client.setUser(user);
            client.setFirstname(request.getFirstname());
            client.setLastname(request.getLastname());
            client.setPhone(request.getPhone());
            client.setActive(request.isActive());
            clientService.createClient(client);
        }

        return user;
    }

    public List<User> getAllUsers(){
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User getUserById(@QueryParam ("id") Long id){
        return entityManager.find(User.class, id);
    }

    public User existsUser(String username, String password){
        List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        if (users.isEmpty()) {
            return null;
        }

        return users.get(0);
    }
    
}
