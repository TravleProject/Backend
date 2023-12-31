package travel.project.springboot.travel.Festival.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.Festival.domain.entity.Festival;

@Getter
public class FestivalResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public FestivalResponse(Festival festival) {
        CommonData commonData = festival.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
