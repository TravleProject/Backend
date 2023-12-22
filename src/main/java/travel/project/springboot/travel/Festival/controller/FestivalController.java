package travel.project.springboot.travel.Festival.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;
import travel.project.springboot.travel.Festival.domain.entity.Festival;
import travel.project.springboot.travel.Festival.dto.FestivalResponse;
import travel.project.springboot.travel.Festival.service.FestivalService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/festivals")
public class FestivalController {

    private final FestivalService festivalService;

    public FestivalController(FestivalService festivalService) {
        this.festivalService = festivalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<Object>> findId(@PathVariable long id) {
        try {
            Festival festival = festivalService.findById(id);
            FestivalResponse response = new FestivalResponse(festival);
            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", response);
        } catch (IllegalArgumentException e) {
            return MakeResponse.getResponseMessage(HttpStatus.NOT_FOUND, "Festival not found");
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> findAll() {
        try {
            List<FestivalResponse> festivalResponses = festivalService.findAll()
                    .stream()
                    .map(FestivalResponse::new)
                    .toList();

            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", festivalResponses);
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
