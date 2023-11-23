package travel.project.springboot.travel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.travel.domain.entity.Travel;
import travel.project.springboot.travel.domain.repository.TravelRepository;

@RequiredArgsConstructor
@Service
public class TravelService {

    private final TravelRepository travelRepository;

    public Travel findById(long id) {
        return travelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
