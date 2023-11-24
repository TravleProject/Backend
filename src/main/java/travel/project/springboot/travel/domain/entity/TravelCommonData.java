package travel.project.springboot.travel.domain.entity;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class TravelCommonData {
    private String title;
    private double latitude;
    private double longitude;
    private String address;
    private String post_code;
    private String out_line;
    private String detail_info;
}
