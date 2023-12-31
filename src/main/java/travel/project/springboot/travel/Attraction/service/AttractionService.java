package travel.project.springboot.travel.Attraction.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.common.entity.CommonDataSpecifications;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;
import travel.project.springboot.travel.Attraction.domain.repository.AttractionRepository;
import travel.project.springboot.travel.Food.domain.entity.Food;

import java.util.List;

@Service
public class AttractionService extends BaseService<Attraction, Long, AttractionRepository> {

    public AttractionService(AttractionRepository repository) {
        super(repository);
    }

    public List<Attraction> findByTitle(String title) {
        return findByTitle(title, null);
    }

    @Override
    public Attraction findById(Long aLong) {
        return null;
    }
}

