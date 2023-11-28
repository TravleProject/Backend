package travel.project.springboot.common;

import java.util.List;

public interface TravelSearch<T> {
    List<T> findAll();
    T findById(long id);
}
