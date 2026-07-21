package Service;

import java.util.List;

import Klase.Appointment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class AppointmentService {
 
    @Inject
    private EntityManager entityManager;

    public void createAppointment(Appointment appointment){
        entityManager.persist(appointment);
    }

    public void deleteAppointment(Appointment appointment){
        entityManager.remove(appointment);
    }

    public Appointment getAppointment(int id){
        return entityManager.find(Appointment.class, id);
    }

    public List<Appointment> getAllAppointments(){
        return entityManager.createQuery("SELECT a FROM Appointment a",Appointment.class).getResultList();
    }

    public List<Appointment> getAppointmentsByClient(int clientId){
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.client.id=:clientID",Appointment.class).setParameter("clientID", clientId).getResultList();
    }

}