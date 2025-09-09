package ghs;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Hotel Reservation System Demonstration ---");

        GuestHouse guestHouse1 = new GuestHouse("The Grand Hotel");
        ReserverPayer johnDoe = new ReserverPayer("John Doe", "123 Main St", "1234-5678-9012-3456");
        Room room101 = new Room(101, RoomType.DOUBLE, 150.0);

        Reservation reservation1 = new Reservation(new Date(), new Date(), 1001, johnDoe, room101);
        
        // Corrected line: Use the public addReservation method to add a reservation.
        guestHouse1.addReservation(reservation1);
        johnDoe.addReservation(reservation1);

        System.out.println("\nSuccessfully created Reservation 1001 for John Doe in room 101.");

        System.out.println("\n--- Attempting to cancel Reservation 1001 ---");
        String cancellationMessage = guestHouse1.cancelReservation(1001);
        System.out.println(cancellationMessage);

        System.out.println("\n--- Attempting to cancel a non-existent reservation ---");
        String invalidCancellationMessage = guestHouse1.cancelReservation(9999);
        System.out.println(invalidCancellationMessage);
        
        System.out.println("\n--- End of Demonstration ---");
    }
}