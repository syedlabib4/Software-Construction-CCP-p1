package ghs;

public class Main {
    public static void main(String[] args) {
        GuestHouse gh = new GuestHouse("Royal Inn");

        ReserverPayer rp = new ReserverPayer();
        Room room = new Room(101);

        Reservation res = new Reservation(1, rp, room);

        rp.addReservation(res);
        room.allocateRoom(res);
        gh.addReservation(res);

        // Cancel the reservation
        String result = gh.cancelReservation(1);
        System.out.println(result); // Should print: Reservation #1 cancelled successfully.
    }
}

