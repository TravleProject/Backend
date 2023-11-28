package travel.project.springboot.travel.Leports.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.travel.Leports.domain.entity.Leports;
import travel.project.springboot.travel.Leports.domain.repository.LeportsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeportsService implements TravelSearch<Leports> {

    private final LeportsRepository leportsRepository;

    @Override
    public Leports findById(long id) {
        return leportsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Override
    public List<Leports> findAll() {
        return leportsRepository.findAll();
    }
}
