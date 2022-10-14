package doublev.partners.tickets.repository;

import doublev.partners.tickets.model.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonRepository extends JpaRepository<UserPerson, Integer> {
}
