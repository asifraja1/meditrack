package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.enums.Specialization;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.IdGenerator;

import java.util.Scanner;

public class Main {

    private static final DoctorService doctorService = new DoctorService();
    private static final PatientService patientService = new PatientService();
    private static final AppointmentService appointmentService = new AppointmentService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Doctor 2.Add Patient 3.Book Appointment 4.Exit");
            int ch = sc.nextInt(); sc.nextLine();

            if (ch == 1) {
                System.out.print("Name: "); String n = sc.nextLine();
                System.out.print("Age: "); int a = sc.nextInt();
                System.out.print("Fee: "); double f = sc.nextDouble();
                Doctor d = new Doctor(IdGenerator.generateId(), n, a,
                        Specialization.CARDIOLOGY, f);
                doctorService.addDoctor(d);
                System.out.println("Doctor ID: " + d.getId());
            }
            else if (ch == 2) {
                System.out.print("Name: "); String n = sc.nextLine();
                System.out.print("Age: "); int a = sc.nextInt();
                Patient p = new Patient(IdGenerator.generateId(), n, a);
                patientService.addPatient(p);
                System.out.println("Patient ID: " + p.getId());
            }
            else if (ch == 3) {
                System.out.print("Doctor ID: "); String d = sc.nextLine();
                System.out.print("Patient ID: "); String p = sc.nextLine();
                Appointment ap = appointmentService.createAppointment(
                        IdGenerator.generateId(),
                        doctorService.getDoctor(d),
                        patientService.getPatient(p)
                );
                System.out.println("Appointment Status: " + ap.getStatus());
            }
            else break;
        }
    }
}