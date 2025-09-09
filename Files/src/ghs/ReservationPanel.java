package ghs;

// This would be a class handling UI events, not part of the core business logic.
// We'll call it ReservationPanel for clarity.
public class ReservationPanel {
    // UI components and class fields would be here.
    private JTextField reservationFeedbackField;
    private JTextField customerNameField;
    private JTextArea customerAddressTextArea;
    private JFormattedTextField creditCardNumberField;
    
    // Other fields like startDate, endDate, etc.
    private Date startDate;
    private Date endDate;
    private String reserverName;
    private String address;
    private String multiLineAddress;
    private String creditCardNo;
    private String existingAddresses;
    private String guestHouseName;
    private RoomType roomType;
    
    private GuestHouseFacade guestHouseChainFacade;

    /**
     * The refactored action listener method for the confirm reservation button.
     * This method is now clean and focuses solely on the user action flow.
     */
    private void confirmReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String validationMessage = validateReservationInputs();

        if (validationMessage != null) {
            reservationFeedbackField.setText(validationMessage);
        } else {
            String reservationMessage = guestHouseChainFacade.makeReservation(
                guestHouseName, startDate, endDate, roomType, reserverName, multiLineAddress, creditCardNo
            );
            reservationFeedbackField.setText(reservationMessage);
            
            if (reservationMessage != null && reservationMessage.startsWith("Confirmed")) {
                setEnabledMakeReservationPanel(false);
            }
        }
    }

    /**
     * This private helper method handles all the input validation.
     * It centralizes the validation logic and makes the main method cleaner.
     * @return The error message if validation fails, otherwise returns null.
     */
    private String validateReservationInputs() {
        if (startDate == null || endDate == null) {
            return "Enter valid dates";
        }
        
        if (reserverName == null || reserverName.isEmpty()) {
            customerNameField.requestFocus();
            return "Enter valid name";
        }
        
        if (address == null || address.isEmpty()) {
            customerAddressTextArea.requestFocus();
            return "Enter valid address";
        }
        
        if (existingAddresses == null && !GuestHouseFacade.isValidCreditCardNumberFormat(creditCardNo)) {
            creditCardNumberField.selectAll();
            creditCardNumberField.requestFocus();
            return GuestHouseFacade.creditCardNumberFormatError(creditCardNo);
        }
        
        return null; // All checks passed
    }

    private void setEnabledMakeReservationPanel(boolean enabled) {
        // This method would enable/disable the UI panel.
    }
}