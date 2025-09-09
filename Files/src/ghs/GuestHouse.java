package ghs;
import java.util.HashMap;

public class GuestHouse {
    private String name;
    private HashMap<Integer, Reservation> reservations;

    public GuestHouse(String name) {
        this.name = name;
        this.reservations = new HashMap<>();
    }

    /**
     * Adds a reservation to the guest house's records.
     * This method is public to allow other classes to add reservations
     * in a controlled manner.
     * @param reservation The reservation to add.
     */
    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.put(reservation.getNumber(), reservation);
        }
    }

    /**
     * Cancels the specified reservation.
     * @param reservationNumber The number of the reservation to cancel.
     * @return A feedback text about the cancelled reservation.
     */
    public String cancelReservation(int reservationNumber) {
        if (reservationNumber <= 0) {
            return "Error: Invalid reservation number. Must be a positive integer.";
        }

        Reservation reservation = reservations.get(reservationNumber);

        if (reservation == null) {
            return "Error: Reservation with number " + reservationNumber + " not found in " + this.name + ".";
        }

        Room room = reservation.getRoom();
        if (room != null) {
            room.deallocateRoom(reservation);
        } else {
            System.err.println("Warning: Reservation " + reservationNumber + " had no associated room.");
        }

        ReserverPayer reserverPayer = reservation.getReserverPayer();
        if (reserverPayer != null) {
            reserverPayer.removeReservation(reservationNumber);
        } else {
            System.err.println("Warning: Reservation " + reservationNumber + " had no associated reserver payer.");
        }

        reservations.remove(reservationNumber);

        return "Reservation " + reservationNumber + " has been successfully cancelled from " + this.name + ".";
    }
}