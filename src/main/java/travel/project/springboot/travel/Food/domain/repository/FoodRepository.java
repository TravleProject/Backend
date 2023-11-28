package travel.project.springboot.travel.Food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.project.springboot.travel.Food.domain.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
