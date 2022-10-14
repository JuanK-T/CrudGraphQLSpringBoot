package doublev.partners.tickets.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import doublev.partners.tickets.exceptions.TicketNotFoundException;
import doublev.partners.tickets.exceptions.UserPersonNotFoundException;
import doublev.partners.tickets.model.Status;
import doublev.partners.tickets.model.Ticket;
import doublev.partners.tickets.model.UserPerson;
import doublev.partners.tickets.repository.TicketRepository;
import doublev.partners.tickets.repository.UserPersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static doublev.partners.tickets.config.ConsoleColors.*;

@Component
@Slf4j
@AllArgsConstructor
public class TicketMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private final TicketRepository ticketRepository;
    private final UserPersonRepository users;

    public Ticket add(Instant createdDate, Integer userId, Status status){
        log.info(GREEN_BOLD_BRIGHT + "Creting one ticket \n CreatedDate: {}. user_id: {}. Status: {}" + RESET, createdDate, userId, status);

        UserPerson userPerson = users.findById(userId).orElseThrow(UserPersonNotFoundException::new);

        Ticket ticket = new Ticket();
        ticket.setCreatedDate(createdDate);
        ticket.setUserPerson(userPerson);
        ticket.setStatus(status);
        ticketRepository.saveAndFlush(ticket);
        return ticket;
    }

    public Ticket update(Integer id, Instant updatedDate, Integer userId, Status status){
        log.info(GREEN_BOLD_BRIGHT + "Update one ticket \n for ID {}. Updated Date: {}. user_id: {}. Status: {}" + RESET, id, updatedDate, userId, status);
        Ticket ticket = ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
        UserPerson userPerson = users.findById(userId).orElseThrow(UserPersonNotFoundException::new);

        ticket.setStatus(status);
        ticket.setUpdatedDate(updatedDate);
        ticket.setUserPerson(userPerson);
        ticketRepository.saveAndFlush(ticket);
        return ticket;
    }

    public Ticket delete(Integer id){
        log.info(RED_BOLD_BRIGHT+ "Dislable one ticket by id {}." + RESET, id);
        Ticket ticket = ticketRepository.findById(id).orElseThrow(TicketNotFoundException::new);
        ticket.setStatus(Status.FALSE);
        ticketRepository.saveAndFlush(ticket);
        return ticket;
    }
}
