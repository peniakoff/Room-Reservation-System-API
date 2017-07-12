package pl.tomaszmiller.roomreservationsystemAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomaszmiller.roomreservationsystemAPI.ReservationRepository;
import pl.tomaszmiller.roomreservationsystemAPI.RoomRepository;
import pl.tomaszmiller.roomreservationsystemAPI.UserRepository;
import pl.tomaszmiller.roomreservationsystemAPI.models.Reservation;
import pl.tomaszmiller.roomreservationsystemAPI.models.Room;
import pl.tomaszmiller.roomreservationsystemAPI.models.User;

import javax.print.attribute.standard.Media;
import javax.validation.constraints.Max;
import java.util.Optional;

/**
 * Created by Tomasz on 11.07.2017.
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/rooms/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllRooms() {
        Iterable<Room> rooms = roomRepository.findAll();
        return new ResponseEntity(rooms, HttpStatus.OK);
    }

    //add, remove rooom

    @RequestMapping(value = "/reservations/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllReservations() {
        Iterable<Reservation> reservations = reservationRepository.findAll();
        return new ResponseEntity(reservations, HttpStatus.OK);
    }

    //add, remove reservation

    @RequestMapping(value = "/users/findByEmail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getUserByEmail(@RequestHeader("Email-Address") String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            int id = user.get().getId();
            return new ResponseEntity(id, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/users/getAll", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getAllUsers(@RequestHeader("Access-Role") String role) {
        Iterable<User> users = userRepository.findAll();
        if (role.equals("Administrator")) {
            return new ResponseEntity(users, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //add, remove user

}
