package travel.project.springboot.travel.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 엔티티로 지정
@Getter // Hetter 메서드를 대체
// 접근제어자를 명시적으로 선언, default public
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "travel_table")
public class Travel {
    /*
    @Id : JPA에서 엔티티 클래스의 기본 키를 나타내는 클래스로
            JPA는 자바 객체와 데이터베이스 간의 매핑을 지원,
            이때, 엔티티 클래스의 특정 필드를 기본 키로 사용하고자 할 때 사용

    updatable = true (기본 값) : 해당 필드는 업데이트가 가능, 즉시 데이터베이스에 변경된 값을 반영할 수 있음
    updateble = false : 해당 필드는 업데이트 불가능, 데이터베이스에 영향을 주지 않음.
                    주로 읽기 전용(read-only)필드나, 특정 조건에서만 업데이트가 가능한 필드 등에 사용
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sequence", updatable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "post_code", nullable = false)
    private int post_code;

    @Column(name = "out_line", nullable = false)
    private String out_line;

    @Column(name = "detail_info", nullable = false)
    private String detail_info;

    @Builder
    public Travel(String title, double latitude, double longitude, String address, int post_code, String out_line, String detail_info) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.post_code = post_code;
        this.out_line = out_line;
        this.detail_info = detail_info;
    }

}
