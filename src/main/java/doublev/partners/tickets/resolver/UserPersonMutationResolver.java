package doublev.partners.tickets.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import doublev.partners.tickets.exceptions.UserPersonNotFoundException;
import doublev.partners.tickets.model.UserPerson;
import doublev.partners.tickets.repository.UserPersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static doublev.partners.tickets.config.ConsoleColors.*;

@Slf4j
@Component
public class UserPersonMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private UserPersonRepository userPersonRepository;

    public UserPerson add(String firstName, String lastName){
        log.info(GREEN_BOLD_BRIGHT + "Creting one user \n FirtsName: {}. LastName: {}" + RESET, firstName, lastName);
        UserPerson userPerson = new UserPerson(firstName, lastName, true);
        userPersonRepository.save(userPerson);
        return userPerson;
    }

    public UserPerson update(Integer id,String firstName, String lastName){
        log.info(GREEN_BOLD_BRIGHT + "Update one user \n for ID{}. FirtsName: {}. LastName: {}" + RESET, id, firstName, lastName);
        UserPerson userPerson = userPersonRepository.findById(id).orElseThrow(UserPersonNotFoundException::new);
        userPerson.setFirstName(firstName);
        userPerson.setLastName(lastName);
        userPersonRepository.saveAndFlush(userPerson);
        return userPerson;
    }

    public UserPerson delete(Integer id){
        log.info(RED_BOLD_BRIGHT+ "Dislable one user by id {}." + RESET, id);
        UserPerson userPerson = userPersonRepository.findById(id).orElseThrow(UserPersonNotFoundException::new);
        userPerson.setStatus(false);
        userPersonRepository.saveAndFlush(userPerson);
        return userPerson;
    }
}
