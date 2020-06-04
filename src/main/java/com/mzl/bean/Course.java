package com.mzl.bean;

/**
 * @ClassName :   Course
 * @Description: 课程
 * @Author: 21989
 * @CreateDate: 2020/6/3 9:00
 * @Version: 1.0
 */
public class Course {

    private String id;
    private String name;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
