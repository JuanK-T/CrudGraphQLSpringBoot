package doublev.partners.tickets.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import doublev.partners.tickets.model.Ticket;
import doublev.partners.tickets.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static doublev.partners.tickets.config.ConsoleColors.BLUE_BOLD_BRIGHT;
import static doublev.partners.tickets.config.ConsoleColors.RESET;

@Slf4j
@Component
@AllArgsConstructor
public class TicketQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private final TicketRepository ticketRepository;

    public Iterable<Ticket> findAll(){
        log.info(BLUE_BOLD_BRIGHT + "Getting all tickets" + RESET);
        return ticketRepository.findAll();
    }

    public Optional<Ticket> findById(Integer id) {
        log.info(BLUE_BOLD_BRIGHT + "Getting information of one ticket by id {}" + RESET, id);
        return ticketRepository.findById(id);
    }

    public Page<Ticket> allTicketPaged(int page, int size){
        log.info(BLUE_BOLD_BRIGHT + "Getting information of Ticket for pagination page {}. size {}" + RESET, page, size);
        PageRequest pageRequest = PageRequest.of(page, size);
        return ticketRepository.findAll(pageRequest);
    }
}
