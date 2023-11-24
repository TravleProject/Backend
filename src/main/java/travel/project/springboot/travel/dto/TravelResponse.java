package travel.project.springboot.travel.dto;

import lombok.Getter;
import travel.project.springboot.travel.domain.entity.Travel;

@Getter
public class TravelResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;
    private final int post_code;
    private final String out_line;
    private final String detail_info;

    public TravelResponse(Travel travel) {
        this.title = travel.getTravelCommonData().getTitle();
        this.latitude = travel.getTravelCommonData().getLatitude();
        this.longitude = travel.getTravelCommonData().getLongitude();
        this.address = travel.getTravelCommonData().getAddress();
        this.post_code = travel.getTravelCommonData().getPost_code();
        this.out_line = travel.getTravelCommonData().getOut_line();
        this.detail_info = travel.getTravelCommonData().getDetail_info();
    }
}
