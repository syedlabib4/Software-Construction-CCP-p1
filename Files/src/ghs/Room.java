package ghs;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a hotel room
 */
public class Room {
    private int roomNumber;
    private Map<Reservation, Boolean> roomReservations = new HashMap<>();

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void allocateRoom(Reservation reservation) {
        roomReservations.put(reservation, true);
    }

    /**
     * Deallocates room from the reservation
     *
     * @param reservation reservation to remove
     */
    public void deallocateRoom(Reservation reservation) {
        roomReservations.remove(reservation);
    }
}
