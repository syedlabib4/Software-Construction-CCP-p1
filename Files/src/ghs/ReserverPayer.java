package ghs;

import java.util.HashMap;
import java.util.Map;

public class ReserverPayer {
    private String name;
    private Map<Integer, Reservation> myReservations;

    public ReserverPayer(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }
        this.name = name;
        this.myReservations = new HashMap<>();
    }

    public String getName() { return name; }

    public void addReservation(Reservation reservation) {
        if (reservation == null) throw new IllegalArgumentException("Reservation cannot be null.");
        myReservations.put(reservation.getReservationNumber(), reservation);
    }

    /**
     * Removes a reservation with the specified number
     * from the reserver's list(HashMap) of reservations
     * @param reservationNumber the unique id of the reservation to remove
     * @pre reservationNumber is positive and must be in the list
     */
    public void removeReservation(int reservationNumber) {
        if (!myReservations.containsKey(reservationNumber)) {
            throw new IllegalArgumentException("Reservation not found in payer's list.");
        }
        myReservations.remove(reservationNumber);
    }

    @Override
    public String toString() {
        return "ReserverPayer: " + name + " with reservations " + myReservations.keySet();
    }
}
