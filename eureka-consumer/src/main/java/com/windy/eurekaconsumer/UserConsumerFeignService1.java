package com.windy.eurekaconsumer;

import com.windy.eurekaproviderapi.ProviderApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider",fallbackFactory = WebError.class)
public interface UserConsumerFeignService1 extends ProviderApi {
}
