package travel.project.springboot.travel.Food.dto;

import lombok.Getter;
import travel.project.springboot.common.entity.CommonData;
import travel.project.springboot.travel.Food.domain.entity.Food;

@Getter
public class FoodResponse {
    private final String title;
    private final double latitude;
    private final double longitude;
    private final String address;

    public FoodResponse(Food food) {
        CommonData commonData = food.getCommonData();
        this.title = commonData.getTitle();
        this.latitude = commonData.getLatitude();
        this.longitude = commonData.getLongitude();
        this.address = commonData.getAddress();
    }
}
