package ghs;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private RoomType kind;
    private double cost;
    private Guest occupant;
    private List<Reservation> roomReservations; // List of reservations for this room

    public Room(int number, RoomType kind, double cost) {
        this.number = number;
        this.kind = kind;
        this.cost = cost;
        this.roomReservations = new ArrayList<>();
    }

    /**
     * Deallocates the room by removing a reservation.
     * @param reservation The reservation to deallocate.
     */
    public void deallocateRoom(Reservation reservation) {
        // Defensive programming: check if the list contains the reservation before removing.
        if (roomReservations.contains(reservation)) {
            roomReservations.remove(reservation);
        }
    }

    // Other methods like allocateRoom, checkOccupied, etc. would go here.
}