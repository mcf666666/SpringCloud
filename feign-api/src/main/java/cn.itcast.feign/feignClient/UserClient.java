package cn.itcast.feign.feignClient;




import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    User getUserInfo(@PathVariable("id") Long id);
}
