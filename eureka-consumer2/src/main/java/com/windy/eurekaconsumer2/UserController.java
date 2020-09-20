package com.windy.eurekaconsumer2;

import com.windy.eurekaproviderapi.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Value("${server.port}")
    String port;

    @Autowired
    UserConsumerFeignService ucs;

    @Autowired
    UserConsumerResttemplateService ucrs;

    @GetMapping("/alive1")
    public String alive1() {
        //Feign与Hystrix整合  回调 fallback
        return "i am consumer,port:"+port+">>>"+ucs.isAlive();
    }


    @GetMapping("/alive2")
    public String alive3() {
        //Resttemplate与Hystrix整合  回调 back
        return ucrs.alive();
    }


    @GetMapping("/id")
    public String getById(@RequestParam Integer id) {
        System.out.println("id:"+id);
        return ucs.getById(id);
    }
    @GetMapping("/person")
    public Person postPerson(@RequestParam Map<String,String> map) {
        Person p = new Person();
        p.setId(Integer.parseInt(map.get("id")));
        p.setName(map.get("name"));
        return ucs.postPerson(p);
    }
}
