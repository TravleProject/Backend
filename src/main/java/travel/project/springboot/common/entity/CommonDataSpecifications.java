package travel.project.springboot.common.entity;

import org.springframework.data.jpa.domain.Specification;

public class CommonDataSpecifications {
    public static <T> Specification<T> titleContains(String title) {
        return (root, query, criteriaBuilder) -> {
            if (title == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // always true = no filter
            }
            return criteriaBuilder.like(root.get("commonData").get("title"), title + "%");
        };
    }
}
