package travel.project.springboot.common;

import java.util.List;

public interface TravelSearch<T, ID> {
    T findById(ID id);
    List<T> findAll();
}

