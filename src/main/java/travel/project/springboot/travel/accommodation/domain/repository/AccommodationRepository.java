package travel.project.springboot.travel.accommodation.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import travel.project.springboot.travel.accommodation.domain.entity.Accommodation;
import travel.project.springboot.travel.accommodation.dto.AccommodationResponse;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long>, JpaSpecificationExecutor<Accommodation> {
}
