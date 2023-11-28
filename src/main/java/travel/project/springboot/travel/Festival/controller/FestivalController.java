package travel.project.springboot.travel.Festival.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.travel.Festival.domain.entity.Festival;
import travel.project.springboot.travel.Festival.dto.FestivalResponse;
import travel.project.springboot.travel.Festival.service.FestivalService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/festivals")
public class FestivalController {

    private final FestivalService festivalService;

    public FestivalController(FestivalService travelService) {
        this.festivalService = travelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FestivalResponse> findId(@PathVariable long id) {
        try {
            Festival festival = festivalService.findById(id);
            return ResponseEntity.ok().body(new FestivalResponse(festival));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FestivalResponse>> findAll() {
        List<FestivalResponse> locationInfo = festivalService.findAll()
                .stream()
                .map(FestivalResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(locationInfo);
    }
}
