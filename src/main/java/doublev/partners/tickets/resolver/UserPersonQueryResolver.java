package doublev.partners.tickets.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import doublev.partners.tickets.model.UserPerson;
import doublev.partners.tickets.repository.UserPersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static doublev.partners.tickets.config.ConsoleColors.*;

@Slf4j
@Component
public class UserPersonQueryResolver implements GraphQLResolver {
    @Autowired
    private UserPersonRepository userPersonRepository;


    public Iterable<UserPerson> findAll(){
        log.info(BLUE_BOLD_BRIGHT + "Getting all users" + RESET);
        return userPersonRepository.findAll();
    }

    public Optional<UserPerson> findById(Integer id) {
        log.info(BLUE_BOLD_BRIGHT + "Getting information of one user by id {}" + RESET, id);
        return userPersonRepository.findById(id);
    }

    public Page<UserPerson> allUserPersonPaged(int page, int size){
        log.info(BLUE_BOLD_BRIGHT + "Getting information of Persons for pagination page {}. size {}" + RESET, page, size);
        PageRequest pageRequest = PageRequest.of(page, size);
        return userPersonRepository.findAll(pageRequest);
    }
}
