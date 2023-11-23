package travel.project.springboot.travel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.project.springboot.travel.domain.entity.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
