package com.windy.eurekaconsumer;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Classname MainController
 * @Description
 * @Date 2020/9/17 17:55
 * @Created by wuhao16
 */
@RestController
public class MainController {
    @Autowired
    DiscoveryClient client;

    @Autowired
    LoadBalancerClient lb;


    @GetMapping("/getHi")
    public String getHi() {

        return "Hi";
    }


    @GetMapping("/client")
    public String client() {
        List<String> services = client.getServices();

        for (String str : services) {
            System.out.println(str);

        }
        return "Hi";
    }

    @GetMapping("/client2")
    public Object client2() {
        return client.getInstances("provider");
    }


    @GetMapping("/client3")
    public Object client3() {

        List<ServiceInstance> instances = client.getInstances("provider");
        for (ServiceInstance ins : instances) {
            EurekaServiceInstance eurekaServiceInstance = (EurekaServiceInstance) ins;
            InstanceInfo info = eurekaServiceInstance.getInstanceInfo();
            System.out.println(info.getStatus().toString());
            System.out.println(ToStringBuilder.reflectionToString(ins));
        }

        return "xxoo";
    }

    @GetMapping("/client5")
    public Object client5() {

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance instance = lb.choose("provider");

        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hi";

        RestTemplate restTemplate = new RestTemplate();

        String respStr = restTemplate.getForObject(url, String.class);

        System.out.println("respStr" + respStr);

        return "xxoo";
    }
}
