package cloud.cont;

import cloud.fegin.feginService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author yh
 * @date 2020-10-31-15:20
 */
@RestController
public class controller {


    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private feginService feginService;

    @GetMapping(value = "/consumer/get/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return feginService.paymentSQL(id);
    }





}
