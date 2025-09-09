package ghs;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Guest House with reservations
 */
public class GuestHouse {
    private String name;
    private Map<Integer, Reservation> reservations;

    public GuestHouse(String name) {
        this.name = name;
        this.reservations = new HashMap<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.put(reservation.getNumber(), reservation);
    }

    /**
     * Cancels the specified reservation by:
     * 1. Removing from guest house
     * 2. Removing from reserverPayer
     * 3. Deallocating the room
     *
     * @param reservationNumber the reservation number to cancel
     * @return feedback message
     */
    public String cancelReservation(int reservationNumber) {
        // Defensive programming: check if reservation exists
        if (!reservations.containsKey(reservationNumber)) {
            return "Reservation #" + reservationNumber + " does not exist.";
        }

        Reservation reservation = reservations.get(reservationNumber);

        if (reservation == null) {
            return "Reservation is null.";
        }

        // Step 1: Deallocate the room
        Room room = reservation.getRoom();
        if (room != null) {
            room.deallocateRoom(reservation);
        }

        // Step 2: Remove from reserver payer
        ReserverPayer reserver = reservation.getReserverPayer();
        if (reserver != null) {
            reserver.removeReservation(reservationNumber);
        }

        // Step 3: Remove from guest house reservation list
        reservations.remove(reservationNumber);

        return "Reservation #" + reservationNumber + " cancelled successfully.";
    }
}
