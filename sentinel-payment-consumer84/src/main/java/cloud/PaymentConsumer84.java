package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yh
 * @date 2020-10-31-15:15
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentConsumer84 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer84.class, args);
    }
}
