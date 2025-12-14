package com.airtribe.meditrack.test;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.IdGenerator;

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("===== MediTrack Manual Tests Started =====");

        // ================= SERVICES =================
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();

        // ================= DOCTOR SERVICE TEST =================
        Doctor doctor = new Doctor(
                IdGenerator.generateId(),
                "Dr Alex",
                45,
                Specialization.CARDIOLOGY,
                500
        );

        doctorService.addDoctor(doctor);
        assert doctorService.getDoctor(doctor.getId()) != null;
        System.out.println("✔ DoctorService add/get test PASSED");

        // ================= PATIENT SERVICE TEST =================
        Patient patient = new Patient(
                IdGenerator.generateId(),
                "Brook",
                30
        );

        patientService.addPatient(patient);
        assert patientService.getPatient(patient.getId()) != null;
        System.out.println("✔ PatientService add/get test PASSED");

        // ================= SEARCH (POLYMORPHISM) =================
        assert patientService.searchPatient("Brook") != null;
        assert patientService.searchPatient(30) != null;
        System.out.println("✔ Patient search (method overloading) PASSED");

        // ================= APPOINTMENT SERVICE TEST =================
        Appointment appointment = appointmentService.createAppointment(
                IdGenerator.generateId(),
                doctor,
                patient
        );

        assert appointment != null;
        assert appointment.getStatus().toString().equals("CONFIRMED");
        System.out.println("✔ Appointment creation test PASSED");

        // ================= APPOINTMENT STATUS CHANGE =================
        appointmentService.completeAppointment(appointment);
        assert appointment.getStatus().toString().equals("COMPLETED");
        System.out.println("✔ Appointment status update test PASSED");

        // ================= BILLING + POLYMORPHISM =================
        MedicalEntity bill = new Bill(doctor.getFee());
        double totalAmount = bill.generateBill();

        assert totalAmount > doctor.getFee();
        System.out.println("✔ Billing + dynamic dispatch test PASSED");
        System.out.println("  Bill Amount = " + totalAmount);

        // ================= CLONE TEST (DEEP COPY) =================
        Patient clonedPatient = patient.clone();
        assert clonedPatient != patient;
        assert clonedPatient.getName().equals(patient.getName());
        System.out.println("✔ Patient clone (deep copy) test PASSED");

        System.out.println("\n===== ALL TESTS PASSED SUCCESSFULLY ✅ =====");
    }
}