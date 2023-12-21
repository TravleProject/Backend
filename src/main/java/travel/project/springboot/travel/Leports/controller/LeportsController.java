package travel.project.springboot.travel.Leports.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.travel.Leports.domain.entity.Leports;
import travel.project.springboot.travel.Leports.dto.LeportsResponse;
import travel.project.springboot.travel.Leports.service.LeportsService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/leports")
public class LeportsController {

    private final LeportsService leportsService;

    public LeportsController(LeportsService travelService) {
        this.leportsService = travelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeportsResponse> findId(@PathVariable long id) {
        try {
            Leports leports = leportsService.findById(id);
            return ResponseEntity.ok().body(new LeportsResponse(leports));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<LeportsResponse>> findAll() {
        List<LeportsResponse> locationInfo = leportsService.findAll()
                .stream()
                .map(LeportsResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(locationInfo);
    }
}
