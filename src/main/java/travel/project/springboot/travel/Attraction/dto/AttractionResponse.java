package travel.project.springboot.travel.Attraction.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;

@Getter
public class AttractionResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public AttractionResponse(Attraction attraction) {
        CommonData commonData = attraction.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
