package travel.project.springboot.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.common.entity.CommonDataSpecifications;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;
import travel.project.springboot.travel.Attraction.dto.AttractionAlllResponse;
import travel.project.springboot.travel.Attraction.dto.AttractionResponse;
import travel.project.springboot.travel.Attraction.service.AttractionService;
import travel.project.springboot.travel.Festival.dto.FestivalAllResponse;
import travel.project.springboot.travel.Festival.dto.FestivalResponse;
import travel.project.springboot.travel.Festival.service.FestivalService;
import travel.project.springboot.travel.Food.dto.FoodAllResponse;
import travel.project.springboot.travel.Food.dto.FoodResponse;
import travel.project.springboot.travel.Food.service.FoodService;
import travel.project.springboot.travel.Leports.dto.LeportsAllResponse;
import travel.project.springboot.travel.Leports.dto.LeportsResponse;
import travel.project.springboot.travel.Leports.service.LeportsService;
import travel.project.springboot.travel.Theme.dto.ThemeAllResponse;
import travel.project.springboot.travel.Theme.dto.ThemeResponse;
import travel.project.springboot.travel.Theme.service.ThemeService;
import travel.project.springboot.travel.accommodation.dto.AccommodationAllResponse;
import travel.project.springboot.travel.accommodation.dto.AccommodationResponse;
import travel.project.springboot.travel.accommodation.service.AccommodationService;


import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/api/travels/info")
public class TravelController {

    private final AccommodationService accommodationService;
    private final FoodService foodService;
    private final AttractionService attractionService;
    private final FestivalService festivalService;
    private final LeportsService leportsService;
    private final ThemeService themeService;

    public TravelController(AccommodationService accommodationService, FoodService foodService,
                            AttractionService attractionService, FestivalService festivalService,
                            LeportsService leportsService, ThemeService themeService) {
        this.accommodationService = accommodationService;
        this.foodService = foodService;
        this.attractionService = attractionService;
        this.festivalService = festivalService;
        this.leportsService = leportsService;
        this.themeService = themeService;
    }

    @Operation(summary = "카테고리 전체 조회", description = "검색한 카테고리를 전체 조회한다. (아래 참고) <br><br>" +
            "＃ 숙박 → accommodation<br>" +
            "＃ 관광지 → attraction<br>" +
            "＃ 축제 → festival<br>" +
            "＃ 음식점 → food<br>" +
            "＃ 레포츠 → leports<br>" +
            "＃ 테마 → theme<br>")
    @GetMapping("/{category}")
    public ResponseEntity<ResponseMessage<Object>> findAllByCategory(
            @Parameter(example = "accommodation", description = "전체 조회할 카테고리 검색")
            @PathVariable String category) {
        List<?> responses;

        switch (category.toLowerCase()) {
            case "accommodation":
                responses = accommodationService.findAll().stream().map(AccommodationResponse::new).toList();
                break;
            case "attraction":
                responses = attractionService.findAll().stream().map(AttractionResponse::new).toList();
                break;
            case "festival":
                responses = festivalService.findAll().stream().map(FestivalResponse::new).toList();
                break;
            case "food":
                responses = foodService.findAll().stream().map(FoodResponse::new).toList();
                break;
            case "leports":
                responses = leportsService.findAll().stream().map(LeportsResponse::new).toList();
                break;
            case "theme":
                responses = themeService.findAll().stream().map(ThemeResponse::new).toList();
                break;
            default:
                throw new IllegalArgumentException("Invalid category");
        }

        return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", responses);
    }

    @Operation(summary = "단일 조회", description = "카테고리와 검색명을 입력하면 해당 카테고리와 검색명에 일치하는 데이터를 반환한다. (아래 참고) <br><br>" +
            "＃ 숙박 → accommodation/서울<br>" +
            "＃ 관광지 → attraction/서해대교<br>" +
            "＃ 축제 → festival/서울국제작가축제<br>" +
            "＃ 음식점 → food/군산집본점<br>" +
            "＃ 레포츠 → leports/서천해양<br>" +
            "＃ 테마 → theme/서해<br>")
    @GetMapping("/search/{category}/{title}")
    public ResponseEntity<ResponseMessage<Object>> searchByTitle(
            @Parameter(example = "accommodation") @PathVariable String category,
            @Parameter(example = "서울") @PathVariable String title) {

        List<?> responses;

        switch (category.toLowerCase()) {
            case "accommodation":
                responses = findByTitle(accommodationService, title, AccommodationAllResponse::new);
                break;
            case "attraction":
                responses = findByTitle(attractionService, title, AttractionAlllResponse::new);
                break;
            case "festival":
                responses = findByTitle(festivalService, title, FestivalAllResponse::new);
                break;
            case "food":
                responses = findByTitle(foodService, title, FoodAllResponse::new);
                break;
            case "leports":
                responses = findByTitle(leportsService, title, LeportsAllResponse::new);
                break;
            case "theme":
                responses = findByTitle(themeService, title, ThemeAllResponse::new);
                break;
            // 다른 카테고리 추가 가능
            default:
                throw new IllegalArgumentException("유효하지 않은 카테고리 또는 검색명");
        }

        return MakeResponse.getResponseMessage(HttpStatus.OK, "성공", responses);
    }

    // 공통 메서드: BaseService에서 상속받은 서비스의 findByTitle을 호출하고 매핑
    private <T, R> List<R> findByTitle(BaseService<T, ?, ?> service, String title, Function<T, R> mapper) {
        Specification<T> spec = CommonDataSpecifications.titleContains(title);
        return service.findByCriteria(spec).stream().map(mapper).toList();
    }
}
