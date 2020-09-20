package com.windy.eurekaconsumer2;

import com.windy.eurekaproviderapi.ProviderApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider",fallbackFactory = WebError.class)
public interface UserConsumerFeignService extends ProviderApi {
}
