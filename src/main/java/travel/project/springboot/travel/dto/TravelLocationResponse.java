package travel.project.springboot.travel.dto;

import lombok.Getter;
import travel.project.springboot.travel.domain.entity.CommonData;
import travel.project.springboot.travel.domain.entity.Travel;

@Getter
public class TravelLocationResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public TravelLocationResponse(Travel travel) {
        CommonData commonData = travel.getTravelCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
