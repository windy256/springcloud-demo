package com.windy.eurekaproviderapi;

import org.springframework.web.bind.annotation.*;

public interface ProviderApi {

    /**
     * 存活判断
     */
    @GetMapping("/user/isAlive")
    String isAlive();

    @GetMapping("/user/getById")
    String getById(@RequestParam Integer id);

    @PostMapping("/user/postPerson")
    Person postPerson(@RequestBody Person person);
}
