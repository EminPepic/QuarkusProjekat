package Klase;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    private String phone;
    private String specialization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;

        
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, user, phone, specialization);
    }

    @Override
    public boolean equals(Object obj) {
       if (obj == null || getClass() != obj.getClass()) {
           return false;
       }
       Trainer trainer = (Trainer) obj;
       return Objects.equals(id, trainer.id) && Objects.equals(firstname, trainer.firstname) && Objects.equals(lastname, trainer.lastname) && Objects.equals(user, trainer.user) && Objects.equals(phone, trainer.phone) && Objects.equals(specialization, trainer.specialization);
    }       
    
}
