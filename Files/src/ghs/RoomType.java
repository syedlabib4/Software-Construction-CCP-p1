package ghs;
public enum RoomType {
    SINGLE,
    DOUBLE,
    SUITE;

    private double cost;

    public double getCost() {
        // Here you would define the cost for each room type
        // For example:
        switch (this) {
            case SINGLE: return 100.0;
            case DOUBLE: return 150.0;
            case SUITE: return 300.0;
            default: return 0.0;
        }
    }
}