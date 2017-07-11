package pl.tomaszmiller.roomreservationsystemAPI;

import org.springframework.data.repository.CrudRepository;
import pl.tomaszmiller.roomreservationsystemAPI.models.User;

import java.util.Optional;

/**
 * Created by Tomasz on 11.07.2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
