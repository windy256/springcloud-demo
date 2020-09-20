package com.windy.eurekaconsumer;

import com.windy.eurekaproviderapi.Person;
import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class WebError implements FallbackFactory<UserConsumerFeignService1> {
    @Override
    public UserConsumerFeignService1 create(Throwable cause) {
        return new UserConsumerFeignService1() {
            @Override
            public String isAlive() {
                System.out.println(cause.getLocalizedMessage());
                if(cause instanceof FeignException.InternalServerError) {
                    System.out.println("InternalServerError");
                    return "远程服务报错";
                }else if(cause instanceof RuntimeException) {

                    return "请求时异常：" + cause;
                }else {
                    return "都算不上";
                }
            }

            @Override
            public String getById(Integer id) {
                return null;
            }

            @Override
            public Person postPerson(Person person) {
                return null;
            }
        };
    }
}
