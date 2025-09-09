package ghs;

/**
 * Represents a reservation made by a reserver for a room
 */
public class Reservation {
    private int number;
    private ReserverPayer reserverPayer;
    private Room room;

    public Reservation(int number, ReserverPayer reserverPayer, Room room) {
        this.number = number;
        this.reserverPayer = reserverPayer;
        this.room = room;
    }

    public int getNumber() {
        return number;
    }

    public ReserverPayer getReserverPayer() {
        return reserverPayer;
    }

    public Room getRoom() {
        return room;
    }
}
