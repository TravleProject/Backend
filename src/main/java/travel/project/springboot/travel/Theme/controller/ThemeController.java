package travel.project.springboot.travel.Theme.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;
import travel.project.springboot.travel.Theme.domain.entity.Theme;
import travel.project.springboot.travel.Theme.dto.ThemeResponse;
import travel.project.springboot.travel.Theme.service.ThemeService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/themes")
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<Object>> findId(@PathVariable long id) {
        try {
            Theme theme = themeService.findById(id);
            ThemeResponse response = new ThemeResponse(theme);
            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", response);
        } catch (IllegalArgumentException e) {
            return MakeResponse.getResponseMessage(HttpStatus.NOT_FOUND, "Theme not found");
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> findAll() {
        try {
            List<ThemeResponse> themeResponses = themeService.findAll()
                    .stream()
                    .map(ThemeResponse::new)
                    .toList();

            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", themeResponses);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
