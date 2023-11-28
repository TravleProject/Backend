package travel.project.springboot.travel.Theme.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.travel.Theme.domain.entity.Theme;
import travel.project.springboot.travel.Theme.domain.repository.ThemeRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ThemeService implements TravelSearch<Theme> {

    private final ThemeRepository themeRepository;

    @Override
    public Theme findById(long id) {
        return themeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Override
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
