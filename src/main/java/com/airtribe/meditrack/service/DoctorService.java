package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.DataStore;

public class DoctorService {

    private final DataStore<Doctor> store = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        store.save(doctor.getId(), doctor);
    }

    public Doctor getDoctor(String id) {
        return store.get(id);
    }
}