package com.isuno2.realmdemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Hezhihu89 on 2017/8/22 0022.
 */
@Entity(
        indexes = {
                @Index(value = "code DESC, stockType DESC", unique = true)
        }
)
public class Student  {
    @Id(autoincrement = true)
    private Long id;
    private Long waiId;
    private String name;
    private String code, stockType;
@Generated(hash = 2104215144)
public Student(Long id, Long waiId, String name, String code,
        String stockType) {
    this.id = id;
    this.waiId = waiId;
    this.name = name;
    this.code = code;
    this.stockType = stockType;
}
@Generated(hash = 1556870573)
public Student() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}
public String getCode() {
    return this.code;
}
public void setCode(String code) {
    this.code = code;
}
public String getStockType() {
    return this.stockType;
}
public void setStockType(String stockType) {
    this.stockType = stockType;
}
public Long getWaiId() {
    return this.waiId;
}
public void setWaiId(Long waiId) {
    this.waiId = waiId;
}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", waiId=" + waiId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", stockType='" + stockType + '\'' +
                '}';
    }
}
