package travel.project.springboot.travel.accommodation.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.accommodation.domain.entity.Accommodation;

@Getter
public class AccommodationResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public AccommodationResponse(Accommodation accommodation) {
        CommonData commonData = accommodation.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
