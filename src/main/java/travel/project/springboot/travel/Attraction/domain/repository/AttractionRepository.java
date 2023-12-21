package travel.project.springboot.travel.Attraction.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}
