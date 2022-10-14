package doublev.partners.tickets.controller;

import doublev.partners.tickets.model.UserPerson;
import doublev.partners.tickets.resolver.UserPersonMutationResolver;
import doublev.partners.tickets.resolver.UserPersonQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserPersonController {
    private final UserPersonQueryResolver users;
    private final UserPersonMutationResolver userPersonMutationResolver;

    @QueryMapping
    public Iterable<UserPerson> allUsers() { return users.findAll(); }

    @QueryMapping
    public Optional<UserPerson> findOneUserById(@Argument Integer id) { return users.findById(id); }

    @QueryMapping
    public Page<UserPerson> allUserPersonPaged(@Argument int page, @Argument int size){ return users.allUserPersonPaged(page, size); }

    @MutationMapping
    public UserPerson createUser(@Argument String firstName, @Argument String lastName){
        return userPersonMutationResolver.add(firstName, lastName);
    }

    @MutationMapping
    public UserPerson updateUser(@Argument Integer id, @Argument String firstName, @Argument String lastName){
        return userPersonMutationResolver.update(id, firstName, lastName);
    }

    @MutationMapping
    public UserPerson deleteUser(@Argument Integer id){
        return userPersonMutationResolver.delete(id);
    }

}
