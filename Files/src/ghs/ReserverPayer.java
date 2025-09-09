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

    public void removeReservation(int reservationNumber) {
        myReservations.remove(reservationNumber);
    }

    public void addReservation(Reservation reservation) {
        myReservations.put(reservation.getNumber(), reservation);
    }
}