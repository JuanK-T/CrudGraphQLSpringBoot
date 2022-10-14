package doublev.partners.tickets.controller;

import doublev.partners.tickets.model.Status;
import doublev.partners.tickets.model.Ticket;
import doublev.partners.tickets.resolver.TicketMutationResolver;
import doublev.partners.tickets.resolver.TicketQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class TicketController {
    private final TicketQueryResolver tickets;
    private final TicketMutationResolver ticketMutationResolver;

    @QueryMapping
    public Iterable<Ticket> allTickets(){ return tickets.findAll(); }

    @QueryMapping
    public Optional<Ticket> findOneTicketById(@Argument Integer id) { return tickets.findById(id); }

    @QueryMapping
    public Page<Ticket> allTicketPaged(@Argument int page, @Argument int size){ return tickets.allTicketPaged(page, size); }

    @MutationMapping
    public Ticket createTicket(@Argument Integer user_id, @Argument Status status){
        return ticketMutationResolver.add(java.time.Instant.now(), user_id, status);
    }

    @MutationMapping
    public Ticket updateTicket(@Argument Integer id, @Argument Integer user_id, @Argument Status status){
        return ticketMutationResolver.update(id, java.time.Instant.now(), user_id, status);
    }

    @MutationMapping
    public Ticket deleteTicket(@Argument Integer id){ return ticketMutationResolver.delete(id); }
}
