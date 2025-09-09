package ghs;
// src/ReservationPanel.java
// src/ReservationPanel.java
// src/ReservationPanel.java
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class ReservationPanel {
    // Placeholder UI components for demonstration
    private JTextField reservationFeedbackField = new JTextField();
    private JTextField customerNameField = new JTextField();
    private JTextArea customerAddressTextArea = new JTextArea();
    private JFormattedTextField creditCardNumberField = new JFormattedTextField();
    
    // Placeholder fields with dummy data to pass validation
    private Date startDate = new Date();
    private Date endDate = new Date();
    private String reserverName = "Labib Bukhari"; // Updated name
    private String address = "123 Main St";
    private String multiLineAddress = "123 Main St";
    private String creditCardNo = "1234567890123456";
    private String existingAddresses = null;
    private String guestHouseName = "The Grand Hotel";
    private Object roomType;
    
    // Instantiate the facade
    private GuestHouseFacade guestHouseChainFacade = new GuestHouseFacade();

    // Simulates the button click
    public void simulateConfirmReservation() {
        confirmReservationButtonActionPerformed(null);
    }
    
    private void confirmReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String validationMessage = validateReservationInputs();

        if (validationMessage != null) {
            System.out.println("Validation Error: " + validationMessage);
            reservationFeedbackField.setText(validationMessage);
        } else {
            String reservationMessage = guestHouseChainFacade.makeReservation(
                guestHouseName, startDate, endDate, reserverName, multiLineAddress, creditCardNo
            );
            System.out.println(reservationMessage);

            // Print the reservations to match your desired output
            System.out.println(guestHouseChainFacade.getAllReservations());
        }
    }

    private String validateReservationInputs() {
        if (startDate == null || endDate == null) {
            return "Enter valid dates";
        }
        if (reserverName == null || reserverName.isEmpty()) {
            return "Enter valid name";
        }
        if (address == null || address.isEmpty()) {
            return "Enter valid address";
        }
        if (existingAddresses == null && !GuestHouseFacade.isValidCreditCardNumberFormat(creditCardNo)) {
            return GuestHouseFacade.creditCardNumberFormatError(creditCardNo);
        }
        return null;
    }
}