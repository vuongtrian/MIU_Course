package cs489.miu.edu.hotel_reservation_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private BigDecimal price;
    private String bedType;
    private Integer numberOfBeds;
    private String description;

    @OneToMany(mappedBy = "roomDetail", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "roomDetail", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<FileData> images = new ArrayList<>();

    public RoomDetail(String type, BigDecimal price, String bedType, Integer numberOfBeds, String description, List<Room> rooms, List<FileData> images) {
        this.type = type;
        this.price = price;
        this.bedType = bedType;
        this.numberOfBeds = numberOfBeds;
        this.description = description;
        this.rooms = rooms;
        this.images = images;
    }
}
