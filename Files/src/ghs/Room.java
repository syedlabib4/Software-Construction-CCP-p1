package ghs;

public class Room {
    private String roomNumber;
    private String kind;
    private boolean available;
    private double pricePerNight;

    // Full constructor
    public Room(String roomNumber, String kind, double pricePerNight) {
        if (roomNumber == null || roomNumber.isBlank()) {
            throw new IllegalArgumentException("Room number cannot be null or blank.");
        }
        if (kind == null || kind.isBlank()) {
            throw new IllegalArgumentException("Room kind cannot be null or blank.");
        }
        if (pricePerNight < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.roomNumber = roomNumber;
        this.kind = kind;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }

    // Extra constructor (default kind + price)
    public Room(String roomNumber) {
        this(roomNumber, "Standard", 0.0);
    }

    public String getRoomNumber() { return roomNumber; }
    public String getKind() { return kind; }
    public boolean isAvailable() { return available; }
    public double getPricePerNight() { return pricePerNight; }

    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Room " + roomNumber +
               " (" + kind + ", Available: " + available +
               ", Price: " + pricePerNight + ")";
    }
}
