package ghs;

import java.util.HashMap;
import java.util.Map;

/**
 * Person who reserves and pays
 */
public class ReserverPayer {
    private Map<Integer, Reservation> myReservations = new HashMap<>();

    public void addReservation(Reservation reservation) {
        myReservations.put(reservation.getNumber(), reservation);
    }

    /**
     * Removes reservation from the reserver's list
     *
     * @param reservationNumber the ID to remove
     */
    public void removeReservation(int reservationNumber) {
        myReservations.remove(reservationNumber);
    }
}

