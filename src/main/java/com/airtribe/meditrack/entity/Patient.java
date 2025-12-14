package com.airtribe.meditrack.entity;

public class Patient extends Person implements Cloneable {

    public Patient(String id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public Patient clone() {
        return new Patient(this.id, this.name, this.age);
    }
}