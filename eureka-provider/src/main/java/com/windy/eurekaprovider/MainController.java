package com.windy.eurekaprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname MainController
 * @Description TODO
 * @Date 2020/9/17 17:39
 * @Created by wuhao16
 */
@RestController
public class MainController {
    @RequestMapping("/hi")
    public String hi() {
        return "Hi,I'm eurekaprovider!";
    }
}
