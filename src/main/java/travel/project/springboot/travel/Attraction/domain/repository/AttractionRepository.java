package travel.project.springboot.travel.Attraction.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import travel.project.springboot.travel.Attraction.domain.entity.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Long>, JpaSpecificationExecutor<Attraction> {
}
