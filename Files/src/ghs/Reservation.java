package ghs;
// src/Reservation.java
import java.util.Date;

public class Reservation {
    private Date startDate;
    private Date endDate;
    private int number;
    private ReserverPayer reserverPayer;
    private Room room;

    public Reservation(Date startDate, Date endDate, int number, ReserverPayer reserverPayer, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
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