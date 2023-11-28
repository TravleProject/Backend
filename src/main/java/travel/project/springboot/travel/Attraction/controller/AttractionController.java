package travel.project.springboot.travel.Attraction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;
import travel.project.springboot.travel.Attraction.dto.AttractionResponse;
import travel.project.springboot.travel.Attraction.service.AttractionService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/attractions")
public class AttractionController {

    private final AttractionService AttractionService;

    public AttractionController(AttractionService travelService) {
        this.AttractionService = travelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttractionResponse> findId (@PathVariable long id) {
        try {
            Attraction attraction = AttractionService.findById(id);
            return ResponseEntity.ok().body(new AttractionResponse(attraction));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AttractionResponse>> findAll() {
        List<AttractionResponse> locationInfo = AttractionService.findAll()
                .stream()
                .map(AttractionResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(locationInfo);
    }
}
