package com.windy.eurekaconsumer2;

import com.windy.eurekaproviderapi.Person;
import org.springframework.stereotype.Component;

@Component
public class AliveBack implements UserConsumerFeignService{
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
