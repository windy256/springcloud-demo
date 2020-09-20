package com.windy.eurekaconsumer2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserConsumerResttemplateService {

    @Autowired
    LoadBalancerClient lb;

    @HystrixCommand(fallbackMethod = "back")
    public String alive(){
    // ribbon 完成客户端的负载均衡，过滤掉down了的节点
    ServiceInstance instance = lb.choose("provider");
    String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/isAlive";
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(url, String.class);
    return result;
    }
    public String back(){
        return "我熔断了(restTemplate)";
    }
}
