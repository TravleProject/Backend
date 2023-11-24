package travel.project.springboot.travel.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티로 지정
@Getter
// 접근제어자를 명시적으로 선언, default public
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "travel_table")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequence", updatable = false)
    private long id;

    @Embedded
    private TravelCommonData travelCommonData;

}
