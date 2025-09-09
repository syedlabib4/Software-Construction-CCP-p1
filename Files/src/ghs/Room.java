package ghs;
// src/Room.java
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private RoomType kind;
    private double cost;
    private Guest occupant;
    private List<Reservation> roomReservations;

    public Room(int number, RoomType kind, double cost) {
        this.number = number;
        this.kind = kind;
        this.cost = cost;
        this.roomReservations = new ArrayList<>();
    }

    public void deallocateRoom(Reservation reservation) {
        if (roomReservations.contains(reservation)) {
            roomReservations.remove(reservation);
        }
    }
}