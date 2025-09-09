package ghs;
// src/GuestHouse.java
import java.util.HashMap;

public class GuestHouse {
    private String name;
    private HashMap<Integer, Reservation> reservations;

    public GuestHouse(String name) {
        this.name = name;
        this.reservations = new HashMap<>();
    }

    public void addReservation(Reservation reservation) {
        if (reservation != null) {
            reservations.put(reservation.getNumber(), reservation);
        }
    }

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