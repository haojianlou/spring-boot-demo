package com.hikvision.springbootdemo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author loujianhao
 */
@Component
public class Prop {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(long randomLong) {
        this.randomLong = randomLong;
    }

    public int getRandomIntInRange() {
        return randomIntInRange;
    }

    public void setRandomIntInRange(int randomIntInRange) {
        this.randomIntInRange = randomIntInRange;
    }

    public int getRandomIntInRange2() {
        return randomIntInRange2;
    }

    public void setRandomIntInRange2(int randomIntInRange2) {
        this.randomIntInRange2 = randomIntInRange2;
    }
}
