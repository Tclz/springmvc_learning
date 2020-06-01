package com.domain;

import java.io.DataInput;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String hobby;
    private Integer age;
    // 测试自定义类型转换器
    private Date date;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "hobby='" + hobby + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
