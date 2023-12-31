package travel.project.springboot.travel.Leports.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import travel.project.springboot.travel.Leports.domain.entity.Leports;

public interface LeportsRepository extends JpaRepository<Leports, Long>, JpaSpecificationExecutor<Leports> {
}
