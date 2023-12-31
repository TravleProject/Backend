package travel.project.springboot.travel.Leports.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.Leports.domain.entity.Leports;

@Getter
public class LeportsResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public LeportsResponse(Leports festival) {
        CommonData commonData = festival.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
