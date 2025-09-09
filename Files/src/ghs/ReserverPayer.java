package ghs;
import java.util.HashMap;

public class ReserverPayer {
    private String name;
    private String addressDetails;
    private String creditCardDetails;
    private HashMap<Integer, Reservation> myReservations;

    public ReserverPayer(String name, String addressDetails, String creditCardDetails) {
        this.name = name;
        this.addressDetails = addressDetails;
        this.creditCardDetails = creditCardDetails;
        this.myReservations = new HashMap<>();
    }

    /**
     * Removes a reservation with the specified number from the reserver's list of reservations.
     * @param reservationNumber The unique ID of the reservation to remove.
     */
    public void removeReservation(int reservationNumber) {
        // @pre reservationNumber is positive and must be in the list
        // This is a precondition, but good practice is to handle cases where it's not.
        myReservations.remove(reservationNumber);
    }

    public void addReservation(Reservation reservation) {
        myReservations.put(reservation.getNumber(), reservation);
    }
}