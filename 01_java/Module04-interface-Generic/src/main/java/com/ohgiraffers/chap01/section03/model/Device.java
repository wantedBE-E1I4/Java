package com.ohgiraffers.chap01.section03.model;

public abstract class Device {
    private String name;
    private String model;

    public Device(String model) {
        this.model = model;
    }

    public abstract void powerOn();
    public abstract void powerOff();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
