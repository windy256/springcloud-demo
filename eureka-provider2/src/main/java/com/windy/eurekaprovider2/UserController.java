package com.windy.eurekaprovider2;

import com.windy.eurekaproviderapi.Person;
import com.windy.eurekaproviderapi.ProviderApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserController implements ProviderApi {

    @Value("${server.port}")
    String port;

    private AtomicInteger count = new AtomicInteger();

    @Override
    public String isAlive() {
        System.out.println("准备");
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("i am port:"+port+"，完成");
        return "i am provider,port:"+port+",ok";
    }

    @Override
    public String getById(Integer id) {
        System.out.println("id:"+id);
        return "id:"+id;
    }

    @Override
    public Person postPerson(Person person) {
        System.out.println(person);
        return person;
    }
}
