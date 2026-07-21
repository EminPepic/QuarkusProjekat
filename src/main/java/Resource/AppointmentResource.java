package Resource;

import java.util.List;

import Klase.Appointment;
import Service.AppointmentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResource {

    @Inject
    AppointmentService appointmentService;

    @POST
    @Path("/create")
    public void createAppointment(Appointment appointment){
        appointmentService.createAppointment(appointment);
    }

    @GET
    @Path("/delete")
    public void deleteAppointment(Appointment appointment){
        appointmentService.deleteAppointment(appointment);
    }

    @GET
    @Path("/getAll")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GET
    @Path("/getByClient")
    public List<Appointment> getAppointmentsByClient(int clientId){
        return appointmentService.getAppointmentsByClient(clientId);
    }
    
}
