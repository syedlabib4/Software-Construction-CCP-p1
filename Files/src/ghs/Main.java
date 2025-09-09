package ghs;

public class Main {
    public static void main(String[] args) {
        GuestHouse guestHouse = new GuestHouse("Green Valley");

        ReserverPayer rp = new ReserverPayer();
        Room room = new Room(101);

        Reservation res = new Reservation(1, rp, room);
        rp.addReservation(res);
        room.allocateRoom(res);
        guestHouse.addReservation(res);

        // Now cancel it
        String result = guestHouse.cancelReservation(1);
        System.out.println(result);
    }
}
