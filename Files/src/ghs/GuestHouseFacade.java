package ghs;
public class GuestHouseFacade {

    public static boolean isValidCreditCardNumberFormat(String creditCardNo) {
        // Dummy implementation for validation
        return creditCardNo != null && creditCardNo.matches("^[0-9\\s]{16,}$");
    }

    public static String creditCardNumberFormatError(String creditCardNo) {
        return "Invalid credit card number format.";
    }

    public String makeReservation(String guestHouseName, Object startDate, Object endDate, Object roomType, String reserverName, String multiLineAddress, String creditCardNo) {
        // Dummy implementation for makeReservation
        // This would perform the actual business logic to create a reservation.
        // For now, it just simulates a confirmation.
        if (startDate != null && endDate != null && !reserverName.isEmpty() && !multiLineAddress.isEmpty()) {
            return "Confirmed: Your reservation is confirmed.";
        }
        return "Failed: Reservation could not be made.";
    }
}