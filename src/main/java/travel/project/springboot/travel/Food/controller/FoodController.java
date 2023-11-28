package travel.project.springboot.travel.Food.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.travel.Food.domain.entity.Food;
import travel.project.springboot.travel.Food.dto.FoodResponse;
import travel.project.springboot.travel.Food.service.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService travelService) {
        this.foodService = travelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodResponse> findId(@PathVariable long id) {
        try {
            Food food = foodService.findById(id);
            return ResponseEntity.ok().body(new FoodResponse(food));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FoodResponse>> findAll() {
        List<FoodResponse> locationInfo = foodService.findAll()
                .stream()
                .map(FoodResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(locationInfo);
    }
}
