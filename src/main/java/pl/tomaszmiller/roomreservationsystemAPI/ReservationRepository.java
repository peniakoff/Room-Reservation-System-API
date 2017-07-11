package pl.tomaszmiller.roomreservationsystemAPI;

import org.springframework.data.repository.CrudRepository;
import pl.tomaszmiller.roomreservationsystemAPI.models.Reservation;

import java.util.List;

/**
 * Created by Tomasz on 11.07.2017.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    List<Reservation> findAll();

}
