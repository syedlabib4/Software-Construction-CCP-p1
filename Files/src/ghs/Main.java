package ghs;

public class Main {
    public static void main(String[] args) {
        GuestHouse guestHouse = new GuestHouse("Iqra Guest House");
        ReserverPayer payer = new ReserverPayer("Ali");

        // Create a reservation request (Q2 style)
        ReservationService.ReservationRequest req =
                new ReservationService.ReservationRequest(
                        "Iqra Guest House",
                        "2025-09-10", "2025-09-12",
                        "Single",
                        "Ali Bukhari",
                        "Karachi, Pakistan",
                        "1234567812345678"
                );

        // Use ReservationService (refactored confirmReservation)
        String feedback = ReservationService.makeReservation(guestHouse, req, payer);

        System.out.println(feedback);

        // Verify if stored properly
        System.out.println("All reservations: " + guestHouse.getReservations());
    }
}




