package com.hikvision.springbootdemo.controller;

import com.hikvision.springbootdemo.entity.Prop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author loujianhao
 */
@RestController
public class HelloController {
    @Value("${test.fullname}")
    private String userName;
    @Value("${test.random.string}")
    private String randomString;
    @Value("${test.random.int}")
    private int randomInt;
    @Value("${test.random.long}")
    private long randomLong;
    @Value("${test.random.intInRange}")
    private int randomIntInRange;
    @Value("${test.random.intInRange2}")
    private int randomIntInRange2;
    @Autowired
    private Prop prop;


    @RequestMapping("hello")
    public String index() {
        return "concatUsername:" + prop.getUserName() +
                "<br />test.random.string:" + randomString +
                "<br />test.random.int:" + randomInt +
                "<br />test.random.long:" + randomLong +
                "<br />test.random.intInRange:" + randomIntInRange +
                "<br />test.random.intInRange2:" + randomIntInRange2;

    }
}
