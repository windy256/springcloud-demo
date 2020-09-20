package com.windy.eurekaconsumer;

import com.windy.eurekaproviderapi.Person;
import org.springframework.stereotype.Component;

@Component
public class AliveBack implements UserConsumerFeignService1 {
    @Override
    public String isAlive() {
        return "我熔断了(Feign.AliveBack)";
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public Person postPerson(Person person) {
        return null;
    }
}
