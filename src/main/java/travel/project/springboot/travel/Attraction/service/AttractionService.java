package travel.project.springboot.travel.Attraction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;
import travel.project.springboot.travel.Attraction.domain.repository.AttractionRepository;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AttractionService implements TravelSearch<Attraction> {

    private final AttractionRepository attractionRepository;

    @Override
    public Attraction findById(long id) {
        return attractionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Override
    public List<Attraction> findAll() {
        return attractionRepository.findAll();
    }
}
