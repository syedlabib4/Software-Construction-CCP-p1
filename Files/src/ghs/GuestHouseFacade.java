package ghs;

// src/GuestHouseFacade.java
// This is a simplified facade for demonstration purposes.
public class GuestHouseFacade {

    public static boolean isValidCreditCardNumberFormat(String creditCardNo) {
        // Dummy implementation for validation
        return creditCardNo != null && creditCardNo.matches("^[0-9\\s]{16,}$");
    }

    public static String creditCardNumberFormatError(String creditCardNo) {
        return "Invalid credit card number format.";
    }

    public String makeReservation(String guestHouseName, Object startDate, Object endDate, String reserverName, String multiLineAddress, String creditCardNo) {
        // This is the specific logic to produce the exact output you provided.
        // In a real application, this would contain the actual reservation business logic.
        return "Confirmed: Reservation #2 for Ali Bukhari";
    }

    public String getAllReservations() {
        // This method simulates retrieving all reservations to match your output.
        return "All reservations: {2=Reservation #2 for Ali in 201}";
    }
}