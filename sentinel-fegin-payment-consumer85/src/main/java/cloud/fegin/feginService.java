package cloud.fegin;

import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yh
 * @date 2020-10-31-16:32
 */

// name为注册中心的服务名称，fallback为业务异常处理类
@FeignClient(value = "payment-provicer", fallback = feignServiceImp.class)
public interface feginService {

    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
