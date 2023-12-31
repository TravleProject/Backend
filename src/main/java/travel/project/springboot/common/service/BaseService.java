package travel.project.springboot.common.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import travel.project.springboot.common.TravelSearch;
import travel.project.springboot.common.entity.CommonDataSpecifications;

import java.util.List;

@Service
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID> & JpaSpecificationExecutor<T>> implements TravelSearch<T, ID> {

    protected final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    public List<T> findByCriteria(Specification<T> spec) {
        return repository.findAll(spec);
    }

    public List<T> findByTitle(String title, Specification<T> spec) {
        Specification<T> titleSpec = CommonDataSpecifications.titleContains(title);
        return repository.findAll(Specification.where(spec).and(titleSpec));
    }
}


