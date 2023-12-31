package travel.project.springboot.travel.Leports.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.Leports.domain.entity.Leports;

@Getter
public class LeportsAllResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;
    private final String post_code;
    private final String out_line;
    private final String detail_info;

    public LeportsAllResponse(Leports festival) {
        CommonData commonData = festival.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.post_code = commonData.getPost_code();
        this.out_line = commonData.getOut_line();
        this.detail_info = commonData.getDetail_info();
        this.address = commonData.getAddress();

    }
}
