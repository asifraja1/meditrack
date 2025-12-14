package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.util.DataStore;

public class AppointmentService {

    private final DataStore<Appointment> store = new DataStore<>();

    public Appointment createAppointment(String id, Doctor doctor, Patient patient) {
        Appointment appt = new Appointment(id, doctor, patient);
        store.save(id, appt);
        return appt;
    }

    public Appointment getAppointment(String id) {
        return store.get(id);
    }

    public void completeAppointment(Appointment appt) {
        appt.complete();
    }
}