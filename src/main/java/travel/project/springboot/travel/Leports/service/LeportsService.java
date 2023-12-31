package travel.project.springboot.travel.Leports.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.travel.Festival.domain.entity.Festival;
import travel.project.springboot.travel.Festival.domain.repository.FestivalRepository;
import travel.project.springboot.travel.Food.domain.entity.Food;
import travel.project.springboot.travel.Leports.domain.entity.Leports;
import travel.project.springboot.travel.Leports.domain.repository.LeportsRepository;

import java.util.List;

@Service
public class LeportsService extends BaseService<Leports, Long, LeportsRepository> {

    public LeportsService(LeportsRepository repository) {
        super(repository);
    }

    public List<Leports> findByTitle(String title) {
        return findByTitle(title, null);
    }
    @Override
    public Leports findById(Long aLong) {
        return null;
    }
}
