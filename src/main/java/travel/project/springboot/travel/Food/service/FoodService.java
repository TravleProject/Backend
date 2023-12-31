package travel.project.springboot.travel.Food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.common.entity.CommonDataSpecifications;
import travel.project.springboot.common.service.BaseService;
import travel.project.springboot.travel.Food.domain.entity.Food;
import travel.project.springboot.travel.Food.domain.repository.FoodRepository;

import java.util.List;

@Service
public class FoodService extends BaseService<Food, Long, FoodRepository> {
    public FoodService(FoodRepository repository) {
        super(repository);
    }

    public List<Food> findByTitle(String title) {
        return findByTitle(title, null);
    }

    @Override
    public Food findById(Long aLong) {
        return null;
    }
}

