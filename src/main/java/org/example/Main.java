package org.example;

import org.patient.Patient;

import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char mode = chooseMode(scan);

        Patient[] patients;
        if (mode == 'I') {
            int amount = inputAmount(scan);
            patients = inputArr(amount);
            }
        else
            patients = generateArr();

        printArr(patients);

        char exit;
        do {
            int method = chooseMethod(scan);
            switch (method) {
                case 1:
                    getPatientsWithDiagnosis(patients);
                    break;
                case 2:
                    getPatientsBySpecifiedCode(scan, patients);
                    break;
                case 3:
                    getPatientsByPhonePrefix(scan, patients);
                    break;
            }
            System.out.print("Do you want to try another method?(y/n):  ");
            exit = scan.next().charAt(0);
        } while (toUpperCase(exit) == 'Y');
    }

    public static char chooseMode(Scanner scan) {
        char mode;

        System.out.println("Do you want to generate array of patients or input array?");
        System.out.print("Input G - generate array or I - input array: ");
        do {
            mode = scan.next().charAt(0);
        } while (mode != 'G' && mode != 'I');
        return mode;
    }

    public static int chooseMethod(Scanner scan) {
        int method;
        System.out.println("1 - print patients with diagnosis");
        System.out.println("2 - print patients with medical code in specified interval");
        System.out.println("3 - print amount and patients with specified telephone prefix");
        System.out.print("Choose a method(input 1 or 2 or 3): ");
        do {
            method = scan.nextInt();
        } while (method != 1 && method != 2 && method != 3);
        return method;
    }

    public static int inputAmount(Scanner scan) {
        int amount;

        System.out.print("Input amount of patients: ");
        do {
            amount = scan.nextInt();
        } while (amount < 0);
        return amount;
    }

    public static Patient[] inputArr(int amount) {
        Scanner scan = new Scanner(System.in);
        Patient[] patients = new Patient[amount];

        for (int i = 0; i < amount; i++) {
            System.out.print("Input an id of patient: ");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.print("Input full name of patient. Surname: ");
            String surname = scan.nextLine();
            System.out.print("First name: ");
            String first_name = scan.nextLine();
            System.out.print("Middle name: ");
            String middle_name = scan.nextLine();
            System.out.print("Input an address: ");
            String address = scan.nextLine();
            System.out.print("Input a telephone: ");
            String telephone = scan.nextLine();
            System.out.print("Input a medical card code: ");
            int medical_card_code = scan.nextInt();
            scan.nextLine();
            System.out.print("Input a diagnosis: ");
            String diagnosis = scan.nextLine();

            patients[i] = new Patient(id, surname, first_name, middle_name, address,
                    telephone, medical_card_code, diagnosis);
        }
        return  patients;
    }

    public static Patient[] generateArr() {
        Patient[] patients = new Patient[] {
                new Patient(1111, "Коваленко", "Олексій", "Петрович",
                        "вул. Київська, 12", "480501234567",
                        123456, "Грип"),
                new Patient(1112, "Іванов", "Олег", "Миколайович",
                        "вул. Лесі Українки, 7", "0501234568",
                        234567, ""),
                new Patient(1113, "Петренко", "Марія", "Олександрівна",
                        "вул. Шевченка, 19", "0501234569",
                        345678, "COVID-19"),
                new Patient(1114, "Сидоренко", "Ірина", "Володимирівна",
                        "вул. Грушевського, 22", "0501234570",
                        456789, ""),
                new Patient(1115, "Ткачук", "Дмитро", "Іванович",
                        "вул. Сагайдачного, 10", "480501234571",
                        567890, "Пневмонія")
        };
        return patients;
    }

    public static void printArr(Patient[] patients) {
        System.out.println("\nCurrent array:");
        for (Patient el : patients) {
            System.out.println(el);
        }
        System.out.print("\n");
    }

    public static void getPatientsWithDiagnosis(Patient[] patients) {
        System.out.println("\nPatients with diagnosis:");
        for (Patient patient : patients) {
            if (!patient.getDiagnosis().isEmpty())
                System.out.println(patient);
        }
    }

    public static void getPatientsBySpecifiedCode(Scanner scan, Patient[] patients) {
        System.out.print("Input a first index: ");
        int first_number = scan.nextInt();
        System.out.print("Input a second index: ");
        int second_number = scan.nextInt();

        System.out.println("\nPatients with medical code in interval: ");
        for (Patient patient : patients) {
            if (first_number <= patient.getMedical_card_code() && patient.getMedical_card_code() <= second_number)
                System.out.println(patient);
        }
    }

    public static void getPatientsByPhonePrefix(Scanner scan, Patient[] patients) {
        scan.nextLine();
        System.out.print("Input a prefix of phone number: ");
        char prefix = scan.next().charAt(0);
        int count = 0;

        for (Patient patient : patients) {
            if (patient.getTelephone().charAt(0) == prefix) {
                System.out.println(patient);
                count++;
            }
        }
        System.out.println("Amount of patient with the prefix in telephone: " + count);
    }
}