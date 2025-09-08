package ghs;

public class ReservationService {

    // Utility class to hold a reservation request
    public static class ReservationRequest {
        String guestHouseName;
        String startDate;
        String endDate;
        String roomType;
        String reserverName;
        String address;
        String creditCardNo;

        public ReservationRequest(String guestHouseName, String startDate, String endDate,
                                  String roomType, String reserverName, String address,
                                  String creditCardNo) {
            this.guestHouseName = guestHouseName;
            this.startDate = startDate;
            this.endDate = endDate;
            this.roomType = roomType;
            this.reserverName = reserverName;
            this.address = address;
            this.creditCardNo = creditCardNo;
        }
    }

    // Validate request data
    private static String validateRequest(ReservationRequest req) {
        if (req.startDate == null || req.endDate == null) {
            return "Enter valid dates";
        }
        if (req.reserverName == null || req.reserverName.isBlank()) {
            return "Enter valid name";
        }
        if (req.address == null || req.address.isBlank()) {
            return "Enter valid address";
        }
        if (req.creditCardNo == null || !isValidCreditCardNumberFormat(req.creditCardNo)) {
            return "Invalid credit card number format";
        }
        return null; // no error
    }

    // Example simple validation: must be 16 digits
    private static boolean isValidCreditCardNumberFormat(String number) {
        return number.matches("\\d{16}");
    }

    // Make reservation
    public static String makeReservation(GuestHouse guestHouse, ReservationRequest req, ReserverPayer payer) {
        String validationError = validateRequest(req);
        if (validationError != null) {
            return validationError;
        }

        // Create new room & reservation (simplified for demo)
        Room room = new Room("201", req.roomType, 7000.0);
        Reservation reservation = new Reservation(2, room, payer);

        guestHouse.getReservations().put(2, reservation);
        payer.addReservation(reservation);
        room.setAvailable(false);

        return "Confirmed: Reservation #" + reservation.getReservationNumber() +
                " for " + req.reserverName;
    }
}
