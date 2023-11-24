package travel.project.springboot.travel.dto;

import lombok.Getter;
import travel.project.springboot.travel.domain.entity.Travel;

@Getter
public class TravelLocationResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public TravelLocationResponse(Travel travel) {
        this.title = travel.getTravelCommonData().getTitle();
        this.latitude = travel.getTravelCommonData().getLatitude();
        this.longitude = travel.getTravelCommonData().getLongitude();
        this.address = travel.getTravelCommonData().getAddress();
    }
}
