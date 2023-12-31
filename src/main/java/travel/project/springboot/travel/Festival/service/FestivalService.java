package travel.project.springboot.travel.Festival.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;
import travel.project.springboot.travel.Attraction.domain.repository.AttractionRepository;
import travel.project.springboot.travel.Festival.domain.entity.Festival;
import travel.project.springboot.travel.Festival.domain.repository.FestivalRepository;
import travel.project.springboot.travel.Food.domain.entity.Food;

import java.util.List;

@Service
public class FestivalService extends BaseService<Festival, Long, FestivalRepository> {

    public FestivalService(FestivalRepository repository) {
        super(repository);
    }

    public List<Festival> findByTitle(String title) {
        return findByTitle(title, null);
    }

    @Override
    public Festival findById(Long aLong) {
        return null;
    }
}

