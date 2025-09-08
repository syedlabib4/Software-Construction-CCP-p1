package ghs;

import java.util.HashMap;
import java.util.Map;

public class GuestHouse {
    private String name;
    private Map<Integer, Reservation> reservations;

    public GuestHouse(String name) {
        this.name = name;
        this.reservations = new HashMap<>();
    }

    public Map<Integer, Reservation> getReservations() {
        return reservations;
    }

    /**
     * Cancels the specified reservation by removing the reservation
     * from the guest house's reservations, removing it from the reserverPayer's
     * reservations and deallocating the room allocated to this reservation.
     *
     * @param reservationNumber the number of the reservation to cancel
     * @return feedback text about the cancelled reservation
     */
    public String cancelReservation(int reservationNumber) {
        if (reservationNumber <= 0) {
            return "Invalid reservation number!";
        }

        Reservation reservation = reservations.get(reservationNumber);
        if (reservation == null) {
            return "No reservation found with number " + reservationNumber;
        }

        // Remove from reserverPayer
        if (reservation.getReserverPayer() != null) {
            reservation.getReserverPayer().removeReservation(reservationNumber);
        }

        // Deallocate room
        if (reservation.getRoom() != null) {
            reservation.getRoom().setAvailable(true);
        }

        // Remove from GuestHouse reservations
        reservations.remove(reservationNumber);

        return "Reservation #" + reservationNumber + " cancelled successfully!";
    }
}
