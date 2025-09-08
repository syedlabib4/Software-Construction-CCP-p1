package ghs;

public class Reservation {
    private int reservationNumber;
    private Room room;
    private ReserverPayer reserverPayer;

    public Reservation(int reservationNumber, Room room, ReserverPayer reserverPayer) {
        if (reservationNumber <= 0) {
            throw new IllegalArgumentException("Reservation number must be positive.");
        }
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null.");
        }
        if (reserverPayer == null) {
            throw new IllegalArgumentException("ReserverPayer cannot be null.");
        }

        this.reservationNumber = reservationNumber;
        this.room = room;
        this.reserverPayer = reserverPayer;
    }

    public int getReservationNumber() { return reservationNumber; }
    public Room getRoom() { return room; }
    public ReserverPayer getReserverPayer() { return reserverPayer; }

    @Override
    public String toString() {
        return "Reservation #" + reservationNumber +
               " for " + reserverPayer.getName() +
               " in " + room.getRoomNumber();
    }
}
