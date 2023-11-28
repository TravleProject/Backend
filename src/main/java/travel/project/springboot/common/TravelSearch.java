package travel.project.springboot.common;

import travel.project.springboot.travel.domain.entity.Travel;

import java.util.List;

public interface TravelSearch {
    List<Travel> findAll();
    Travel findById(long id);
}
