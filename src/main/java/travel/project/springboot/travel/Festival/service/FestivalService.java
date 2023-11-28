package travel.project.springboot.travel.Festival.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.travel.Festival.domain.entity.Festival;
import travel.project.springboot.travel.Festival.domain.repository.FestivalRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FestivalService implements TravelSearch<Festival> {

    private final FestivalRepository festivalRepository;

    @Override
    public Festival findById(long id) {
        return festivalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Override
    public List<Festival> findAll() {
        return festivalRepository.findAll();
    }
}
