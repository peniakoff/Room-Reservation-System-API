package pl.tomaszmiller.roomreservationsystemAPI.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Tomasz on 11.07.2017.
 */
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String room_number;
    private int room_seats;
    private int type;

    public Room() {
    }

    public Room(String room_number, int room_seats, int type) {
        this.room_number = room_number;
        this.room_seats = room_seats;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public int getRoom_seats() {
        return room_seats;
    }

    public void setRoom_seats(int room_seats) {
        this.room_seats = room_seats;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
