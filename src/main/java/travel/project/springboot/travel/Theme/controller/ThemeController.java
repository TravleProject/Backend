package travel.project.springboot.travel.Theme.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.project.springboot.travel.Theme.domain.entity.Theme;
import travel.project.springboot.travel.Theme.dto.ThemeResponse;
import travel.project.springboot.travel.Theme.service.ThemeService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/themes")
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService travelService) {
        this.themeService = travelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeResponse> findId(@PathVariable long id) {
        try {
            Theme theme = themeService.findById(id);
            return ResponseEntity.ok().body(new ThemeResponse(theme));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ThemeResponse>> findAll() {
        try {
            List<ThemeResponse> locationInfo = themeService.findAll()
                    .stream()
                    .map(ThemeResponse::new)
                    .toList();

            return ResponseEntity.ok().body(locationInfo);
        } catch (Exception e) {
            // 예외 로깅
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
