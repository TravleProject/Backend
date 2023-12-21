package travel.project.springboot.travel.Food.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.travel.Food.domain.entity.Food;
import travel.project.springboot.travel.Food.domain.repository.FoodRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService implements TravelSearch<Food> {

    private final FoodRepository foodRepository;

    @Override
    public Food findById(long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }
}
