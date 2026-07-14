package Service;

import Klase.Trainer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TrainerService {
    
    @Inject
    EntityManager entityManager;

    @Transactional
    public Trainer createTrainer(Trainer trainer){

        entityManager.persist(trainer);

        return trainer;
    }

    
}
