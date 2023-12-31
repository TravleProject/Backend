package travel.project.springboot.travel.Theme.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import travel.project.springboot.travel.Theme.domain.entity.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long>, JpaSpecificationExecutor<Theme> {
}
