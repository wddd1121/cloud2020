package cloud.fegin;

import com.yh.cloud.pojo.CommonResult;
import com.yh.cloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * @author yh
 * @date 2020-10-31-16:33
 */
@Component
public class feignServiceImp implements feginService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(500, "当前服务不可用");
    }
}
