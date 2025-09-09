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
        Reservation reservation = reservations.get(reservationNumber);

        if (reservation == null) {
            return "Reservation #" + reservationNumber + " does not exist.";
        }

        String feedback = reservation.cancel();
        reservations.remove(reservationNumber);
        return feedback;
    }
}
