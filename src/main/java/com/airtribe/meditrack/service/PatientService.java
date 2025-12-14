package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.DataStore;

public class PatientService implements Searchable {

    private final DataStore<Patient> store = new DataStore<>();

    public void addPatient(Patient patient) {
        store.save(patient.getId(), patient);
    }

    public Patient getPatient(String id) {
        logSearch(id);
        return store.get(id);
    }

    public Patient searchPatient(String name) {
        return store.getAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public Patient searchPatient(int age) {
        return store.getAll().stream()
                .filter(p -> p.getAge() == age)
                .findFirst().orElse(null);
    }
}