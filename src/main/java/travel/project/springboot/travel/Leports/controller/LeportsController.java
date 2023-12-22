package travel.project.springboot.travel.Leports.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.project.springboot.global.response.MakeResponse;
import travel.project.springboot.global.response.ResponseMessage;
import travel.project.springboot.travel.Leports.domain.entity.Leports;
import travel.project.springboot.travel.Leports.dto.LeportsResponse;
import travel.project.springboot.travel.Leports.service.LeportsService;

import java.util.List;

@RestController
@RequestMapping("/api/travels/leports")
public class LeportsController {

    private final LeportsService leportsService;

    public LeportsController(LeportsService leportsService) {
        this.leportsService = leportsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage<Object>> findId(@PathVariable long id) {
        try {
            Leports leports = leportsService.findById(id);
            LeportsResponse response = new LeportsResponse(leports);
            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", response);
        } catch (IllegalArgumentException e) {
            return MakeResponse.getResponseMessage(HttpStatus.NOT_FOUND, "Leports not found");
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @GetMapping
    public ResponseEntity<ResponseMessage<Object>> findAll() {
        try {
            List<LeportsResponse> leportsResponses = leportsService.findAll()
                    .stream()
                    .map(LeportsResponse::new)
                    .toList();

            return MakeResponse.getResponseMessage(HttpStatus.OK, "Success", leportsResponses);
        } catch (Exception e) {
            return MakeResponse.getResponseMessage(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
