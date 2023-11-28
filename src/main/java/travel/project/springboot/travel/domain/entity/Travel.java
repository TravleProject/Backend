package travel.project.springboot.travel.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import travel.project.springboot.common.CommonData;

@Entity // 엔티티로 지정
@Getter
// 접근제어자를 명시적으로 선언, default public
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", updatable = false)
    private long id;

    @Embedded
    private CommonData travelCommonData;

}
