package travel.project.springboot.travel.Attraction.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;
import travel.project.springboot.travel.Attraction.dto.AttractionResponse;
import travel.project.springboot.travel.Attraction.service.AttractionService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/attractions")
public class AttractionController {

    private final AttractionService attractionService;

    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<Object>> findId(@PathVariable long id) {
        try {
            Attraction attraction = attractionService.findById(id);
            AttractionResponse response = new AttractionResponse(attraction);
            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", response);
        } catch (IllegalArgumentException e) {
            return MakeResponse.getResponseMessage(HttpStatus.NOT_FOUND, "Attraction not found");
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> findAll() {
        try {
            List<AttractionResponse> attractionResponses = attractionService.findAll()
                    .stream()
                    .map(AttractionResponse::new)
                    .toList();

            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", attractionResponses);
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
