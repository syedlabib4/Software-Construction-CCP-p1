package ghs;

public class Main {
    public static void main(String[] args) {
        GuestHouse guestHouse = new GuestHouse("Green Palace");

        // Create a room
        Room room101 = new Room("101", "Single", 5000.0);

        // Create payer & reservation
        ReserverPayer payer = new ReserverPayer("Ali");
        Reservation res1 = new Reservation(1, room101, payer);

        // Save in guest house + payer
        guestHouse.getReservations().put(1, res1);
        payer.addReservation(res1);
        room101.setAvailable(false);

        System.out.println("Before cancellation:");
        System.out.println("Reservations: " + guestHouse.getReservations());
        System.out.println("Room available? " + room101.isAvailable());

        // Cancel reservation
        String feedback = guestHouse.cancelReservation(1);
        System.out.println("Cancel feedback: " + feedback);

        System.out.println("\nAfter cancellation:");
        System.out.println("Reservations: " + guestHouse.getReservations());
        System.out.println("Room available? " + room101.isAvailable());
    }
}
