package pl.tomaszmiller.roomreservationsystemAPI;

import org.springframework.data.repository.CrudRepository;
import pl.tomaszmiller.roomreservationsystemAPI.models.Room;

import java.util.List;

/**
 * Created by Tomasz on 11.07.2017.
 */
public interface RoomRepository extends CrudRepository<Room, Integer> {

    List<Room> findAll();

}
