package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.enums.AppointmentStatus;

public class Appointment {

    private String id;
    private Doctor doctor;
    private Patient patient;
    private AppointmentStatus status;

    public Appointment(String id, Doctor doctor, Patient patient) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.status = AppointmentStatus.CONFIRMED;
    }

    public String getId() { return id; }
    public AppointmentStatus getStatus() { return status; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }

    public void complete() { status = AppointmentStatus.COMPLETED; }
    public void cancel() { status = AppointmentStatus.CANCELLED; }
}