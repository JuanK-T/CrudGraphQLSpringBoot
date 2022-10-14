package doublev.partners.tickets.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.util.annotation.Nullable;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private Instant createdDate;
    @Nullable
    private Instant updatedDate;
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false)
    private UserPerson userPerson;

    public Ticket(Instant createdDate, Instant updatedDate, UserPerson userPerson, Status status) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.userPerson = userPerson;
        this.status = status;
    }

    @Override
    public String toString(){
        return "Ticket{" + "id=" + id + ", CreatedDate='" + createdDate;
    }
}
