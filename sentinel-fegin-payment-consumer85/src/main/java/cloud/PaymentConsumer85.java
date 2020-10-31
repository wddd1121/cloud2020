package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yh
 * @date 2020-10-31-15:15
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class PaymentConsumer85 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer85.class, args);
    }
}
