package org.example;

public class Employee {
    private final String name;
    private final int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Job getJob() {
        return job;
    }

    private final Job job;

    public Employee(String name, int age, Job job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
}
