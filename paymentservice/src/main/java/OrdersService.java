import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Mikesam on 2017/8/7.
 */
@SpringBootApplication(scanBasePackages = "com.mcylm.clay.service.paymentservice.*")
@MapperScan("com.mcylm.clay.service.paymentservice.mapper")
@EnableEurekaServer
public class OrdersService {
    public static void main(String[] args) {
        SpringApplication.run(OrdersService.class,args);
    }
}
