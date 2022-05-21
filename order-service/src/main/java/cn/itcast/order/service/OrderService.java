package cn.itcast.order.service;

import cn.itcast.feign.feignClient.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;



    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.拼接请求路径
        Long userId = order.getUserId();
        //使用Fegin客户端发送请求
        User userInfo = userClient.getUserInfo(userId);
////        String url = "http://localhost:8081/user/"+userId;
//        String url = "http://userservice/user/"+userId;
//        // 3.利用RestTemplate发送HTTP请求
//        User uesr = restTemplate.getForObject(url, User.class);
        order.setUser(userInfo);
        // 4.返回
        return order;
    }
}
