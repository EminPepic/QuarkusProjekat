package Klase;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String time;
    private String status;
    private String note;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name="trainer_id")
    private Trainer trainer;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Appointment appointment = (Appointment) obj;
        return Objects.equals(id, appointment.id) && Objects.equals(date, appointment.date) && Objects.equals(time, appointment.time) && Objects.equals(status, appointment.status) && Objects.equals(note, appointment.note) && Objects.equals(client, appointment.client) && Objects.equals(trainer, appointment.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, time, status, note, client, trainer);
    }
    
}
