package com.hikvision.springbootdemo.controller;

import com.hikvision.springbootdemo.entity.Prop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


/**
 * @author loujianhao
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass().toString());

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
    /**
     * 服务发现客户端
     */
    @Autowired
    private DiscoveryClient client;

    /**
     * 服务注册
     */
    @Autowired
    private Registration registration;


    @RequestMapping("hello")
    public String index() {
        return "concatUsername:" + prop.getUserName() +
                "<br />test.random.string:" + randomString +
                "<br />test.random.int:" + randomInt +
                "<br />test.random.long:" + randomLong +
                "<br />test.random.intInRange:" + randomIntInRange +
                "<br />test.random.intInRange2:" + randomIntInRange2;

    }

    @RequestMapping("DiscoveryClient")
    public String DiscoveryClient() {
        ServiceInstance instance = serviceInstance();
        if (instance != null) {
            logger.info("/hello,host:" + instance.getHost() + "<br/>service_id:" + instance.getServiceId());
        }
        return "DiscoveryClient";
    }

    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            for (ServiceInstance serviceInstance : list) {
                if (serviceInstance.getPort() == 8080) {
                    return serviceInstance;
                }
            }
        }
        return null;
    }
}
