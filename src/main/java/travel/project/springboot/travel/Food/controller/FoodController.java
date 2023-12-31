package travel.project.springboot.travel.Food.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;
import travel.project.springboot.travel.Food.domain.entity.Food;
import travel.project.springboot.travel.Food.dto.FoodResponse;
import travel.project.springboot.travel.Food.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Operation(summary = "음식점 카테고리 검색", description = "검색한 음식점 정보를 반환")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<Object>> findId(@Parameter(example = "검색할 음식점 상호명")
                                                              @PathVariable(value = "니와") long id) {
        try {
            Food food = foodService.findById(id);
            FoodResponse response = new FoodResponse(food);
            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", response);
        } catch (IllegalArgumentException e) {
            return MakeResponse.getResponseMessage(HttpStatus.NOT_FOUND, "Food not found");
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> findAll() {
        try {
            List<FoodResponse> foodResponses = foodService.findAll()
                    .stream()
                    .map(FoodResponse::new)
                    .toList();

            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", foodResponses);
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}