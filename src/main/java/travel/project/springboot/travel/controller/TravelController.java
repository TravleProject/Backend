package travel.project.springboot.travel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.travel.domain.entity.Travel;
import travel.project.springboot.travel.dto.TravelResponse;
import travel.project.springboot.travel.service.TravelService;

@RequiredArgsConstructor
@RestController
public class TravelController {

    private final TravelService travelService;

    @GetMapping("/api/travels/{id}")
    public ResponseEntity<TravelResponse> findTravel(@PathVariable long id) {
        try {
            Travel travel = travelService.findById(id);
            return ResponseEntity.ok().body(new TravelResponse(travel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
