package doublev.partners.tickets.data;

import com.github.javafaker.Faker;
import doublev.partners.tickets.model.Status;
import doublev.partners.tickets.model.Ticket;
import doublev.partners.tickets.model.UserPerson;
import doublev.partners.tickets.repository.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

//implements CommandLineRunner
@Component
public class SampleDataLoader implements CommandLineRunner {
    private final TicketRepository ticketRepository;
    private final Faker faker;

    public SampleDataLoader(TicketRepository ticketRepository, Faker faker) {
        this.ticketRepository = ticketRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception{
        // create 100 rows of fake data
        List<Ticket> ticket = IntStream.rangeClosed(1,20)
                .mapToObj(i -> new Ticket(
                        java.time.Instant.now(),
                        null,
                        new UserPerson(
                                faker.name().firstName(),
                                faker.name().lastName(),
                                true
                        ), ((i % 2) == 0) ?  Status.TRUE : Status.FALSE
                )).toList();
        ticketRepository.saveAll(ticket);
    }
}

