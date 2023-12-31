package travel.project.springboot.travel.Theme.service;

import org.springframework.stereotype.Service;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.travel.Festival.domain.entity.Festival;
import travel.project.springboot.travel.Festival.domain.repository.FestivalRepository;
import travel.project.springboot.travel.Theme.domain.entity.Theme;
import travel.project.springboot.travel.Theme.domain.repository.ThemeRepository;

import java.util.List;

@Service
public class ThemeService extends BaseService<Theme, Long, ThemeRepository> {

    public ThemeService(ThemeRepository repository) {
        super(repository);
    }

    public List<Theme> findByTitle(String title) {
        return findByTitle(title, null);
    }

    @Override
    public Theme findById(Long aLong) {
        return null;
    }
}

