package travel.project.springboot.travel.accommodation.service;

import org.springframework.stereotype.Service;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.travel.accommodation.domain.entity.Accommodation;
import travel.project.springboot.travel.accommodation.domain.repository.AccommodationRepository;
import travel.project.springboot.travel.accommodation.dto.AccommodationResponse;

import java.util.List;

@Service
public class AccommodationService extends BaseService<Accommodation, Long, AccommodationRepository> {

    public AccommodationService(AccommodationRepository repository) {
        super(repository);
    }

    public List<Accommodation> findByTitle(String title) {
        return findByTitle(title, null);
    }

    @Override
    public Accommodation findById(Long aLong) {
        return null;
    }
}

