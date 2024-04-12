package cs489.miu.edu.hotel_reservation_service.entity.enumObj;

public enum RoomType {
    SINGLE("Single Room", BedType.SINGLE, 1, 100.0),
    DOUBLE("Double Room", BedType.DOUBLE, 1, 150.0),
    TWIN("Twin Room", BedType.TWIN, 2, 180.0),
    SUITE("Suite", BedType.KING, 2, 300.0);

    private final String name;
    private final BedType bedType;
    private final int numberOfBeds;
    private final double price;

    RoomType(String name, BedType bedType, int numberOfBeds, double price) {
        this.name = name;
        this.bedType = bedType;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BedType getBedType() {
        return bedType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }
}
