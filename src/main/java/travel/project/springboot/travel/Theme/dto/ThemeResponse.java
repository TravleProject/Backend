package travel.project.springboot.travel.Theme.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.Theme.domain.entity.Theme;

@Getter
public class ThemeResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;
    //private final String post_code;
    //private final String out_line;
    //private final String detail_info;

    public ThemeResponse(Theme theme) {
        CommonData commonData = theme.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
