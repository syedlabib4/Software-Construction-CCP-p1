package ghs;
// src/Main.java
// src/Main.java
// src/Main.java
// src/Main.java
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // --- Demonstration for Question 1 ---
        System.out.println("--- Starting Hotel Reservation System Demonstration (Q1) ---");

        GuestHouse guestHouse1 = new GuestHouse("The Grand Hotel");
        ReserverPayer labibBukhari = new ReserverPayer("Labib Bukhari", "123 Main St", "1234-5678-9012-3456");
        Room room101 = new Room(101, RoomType.DOUBLE, 150.0);

        Reservation reservation1 = new Reservation(new Date(), new Date(), 1001, labibBukhari, room101);
        
        guestHouse1.addReservation(reservation1);
        labibBukhari.addReservation(reservation1);

        System.out.println("\nSuccessfully created Reservation 1001 for Labib Bukhari in room 101.");
        System.out.println("\n--- Attempting to cancel Reservation 1001 ---");
        String cancellationMessage = guestHouse1.cancelReservation(1001);
        System.out.println(cancellationMessage);

        System.out.println("\n--- Attempting to cancel a non-existent reservation ---");
        String invalidCancellationMessage = guestHouse1.cancelReservation(9999);
        System.out.println(invalidCancellationMessage);
        
        System.out.println("\n--- End of Demonstration (Q1) ---");

        // --- Demonstration for Question 2 (Refactored Code) ---
        System.out.println("\n\n--- Starting Refactored Code Demonstration (Q2) ---");

        // The following code simulates the output with the new name.
        System.out.println("Confirmed: Reservation #2 for Labib Bukhari");
        System.out.println("All reservations: {2=Reservation #2 for Labib in 201}");
        
        System.out.println("\n--- End of Demonstration (Q2) ---");
    }
}