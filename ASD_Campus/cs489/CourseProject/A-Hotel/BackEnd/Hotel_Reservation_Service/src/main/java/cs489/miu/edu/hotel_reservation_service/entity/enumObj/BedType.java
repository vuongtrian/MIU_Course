package cs489.miu.edu.hotel_reservation_service.entity.enumObj;

public enum BedType {
    SINGLE("Single Bed"),
    DOUBLE("Double Bed"),
    TWIN("Twin Bed"),
    KING("King Bed");

    private final String displayName;

    BedType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
