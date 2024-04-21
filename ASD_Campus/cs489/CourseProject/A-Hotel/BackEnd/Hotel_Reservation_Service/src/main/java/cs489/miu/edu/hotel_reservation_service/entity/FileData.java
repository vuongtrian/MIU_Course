package cs489.miu.edu.hotel_reservation_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private String name;
    private String path;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_detail_id")
    private RoomDetail roomDetail;

    public FileData(String type, String name, String path, RoomDetail roomDetail) {
        this.type = type;
        this.name = name;
        this.path = path;
        this.roomDetail = roomDetail;
    }
}
