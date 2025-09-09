package ghs;

// src/Guest.java
public class Guest {
    private String name;
    private String addressDetails;

    public Guest(String name, String addressDetails) {
        this.name = name;
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }
}