package travel.project.springboot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class TravelApplication {

    private static final Logger logger = LoggerFactory.getLogger(TravelApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);

        // 환경 변수 존재 여부 확인
        String dbPassword = System.getenv("MYSQL_SECRET");
        if (dbPassword != null) {
            logger.info("환경 변수 MYSQL_SECRET이 설정되었습니다.");
        } else {
            logger.error("환경 변수 MYSQL_SECRET이 설정되지 않았습니다!");
        }
    }
}
