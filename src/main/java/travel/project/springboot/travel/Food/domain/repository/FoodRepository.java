package travel.project.springboot.travel.Food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import travel.project.springboot.travel.Food.domain.entity.Food;

import java.util.*;

public interface FoodRepository extends JpaRepository<Food, Long>, JpaSpecificationExecutor<Food> {
    List<Food> findByCommonData_Title(String title);
}
